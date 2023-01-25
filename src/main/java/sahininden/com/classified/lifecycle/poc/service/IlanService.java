package sahininden.com.classified.lifecycle.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sahininden.com.classified.lifecycle.poc.entity.Ilan;
import sahininden.com.classified.lifecycle.poc.entity.LogIlanTable;
import sahininden.com.classified.lifecycle.poc.enums.IlanCategory;
import sahininden.com.classified.lifecycle.poc.enums.IlanStatus;
import sahininden.com.classified.lifecycle.poc.model.*;
import sahininden.com.classified.lifecycle.poc.repository.IlanRepository;
import sahininden.com.classified.lifecycle.poc.repository.LogIlanTableRepository;
import sahininden.com.classified.lifecycle.poc.utils.StringOperator;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class IlanService {
	@Autowired
	IlanRepository ilanRepository;
	@Autowired
	LogIlanTableRepository logIlanTableRepository;
	@Autowired
	StringOperator stringOperator;
	@Value("${title.length.lower.limit}")
	private int lower;
	@Value("${title.length.upper.limit}")
	private int upper;
	@Value("${description.length.lower.limit}")
	private int descriptionLower;
	@Value("${description.upper.lower.limit}")
	private int descriptionUpper;

	public void InsertData(IlanRequestModel req) throws Exception {
		IlanCategory vlu = stringOperator.findByIlanCategoryEnumValue(req.getCategory());
		if( vlu == null)
			throw new Exception();
		if (!stringOperator.firstCharIsValid(req.getTitle()))
			throw new Exception();
		if (req.getTitle().length() >= lower && req.getTitle().length() <= upper) {
			if (req.getDescription().length() >= descriptionLower && req.getDescription().length() <= descriptionUpper) {
				if(stringOperator.containWords(req.getTitle().split(" ")))
					throw new Exception();
				else if(stringOperator.containWords(req.getDescription().split(" "))){
					throw new Exception();
				} else {
					List<Ilan> sqlRes =  ilanRepository.findByCategoryAndTitleAndDescription(vlu, req.getTitle(), req.getDescription());
					ilanRepository.save(new Ilan(req.getTitle(), req.getDescription(),
							vlu, (vlu.name().equals(IlanCategory.ALISVERIS.name())) ? IlanStatus.AKTIF : IlanStatus.ONAYDA,
							Timestamp.from(Instant.now().plus(Duration.ofDays(
									(vlu.name().equals(IlanCategory.EMLAK.name()))? 28:
									(vlu.name().equals(IlanCategory.VASITA.name()))? 21:56))), (sqlRes != null && !sqlRes.isEmpty())));
				}
			} else
				throw new Exception();
		} else
			throw new Exception();
	}

	public StatisticsResponse getDataAlls() {
		StatisticsResponse res = new StatisticsResponse();
		res.setAktifCount(ilanRepository.countByStatus(IlanStatus.AKTIF));
		res.setDeaktifCount(ilanRepository.countByStatus(IlanStatus.DEAKTIF));
		res.setOnayCount(ilanRepository.countByStatus(IlanStatus.ONAYDA));
		return res;
	}

	public List<IlanResponseModel> getOnayList() {
		List<IlanResponseModel> res = new ArrayList<>();
		ilanRepository.findByStatusAndRepeated(IlanStatus.ONAYDA, false).forEach((ilan) ->{
			res.add(new IlanResponseModel(ilan.getTitle(), ilan.getDescription(), ilan.getCategory().getValue(), ilan.getStatus().getValue(), ilan.getId(), ilan.getExpiryDate().toInstant(), ilan.getRepeated()));
		});
		return res;
	}

	public void updateIlan(IlanUpdateRequestModel model) {
		Ilan res = ilanRepository.findById(model.getId());
		if (res != null) {
			if (!res.getRepeated()) {
				logIlanTableRepository.save(new LogIlanTable(res.getId(), res.getStatus().getValue(), (model.getOnay())? IlanStatus.AKTIF.getValue() : IlanStatus.DEAKTIF.getValue()));
				res.setStatus((model.getOnay())? IlanStatus.AKTIF : IlanStatus.DEAKTIF);
				ilanRepository.save(res);
			}
		}
	}

	public List<LogIlanReponseModel> getlogIlanList() {
		List<LogIlanReponseModel> res = new ArrayList<>();
		logIlanTableRepository.findAll().forEach((ilan) -> {
			res.add(new LogIlanReponseModel(ilan.getOldValue(), ilan.getNewValue(), ilan.getIlanId(), ilan.getCreatedDate().toInstant()));
		});
		return res;
	}

	public List<LogIlanReponseModel> getOneRecordLogIlan(IlanIdModel model) {
		List<LogIlanReponseModel> res = new ArrayList<>();
		logIlanTableRepository.findByIlanId(model.getIlanId()).forEach((ilan) -> {
			res.add(new LogIlanReponseModel(ilan.getOldValue(), ilan.getNewValue(), ilan.getIlanId(), ilan.getCreatedDate().toInstant()));
		});
		return res;
	}

}
