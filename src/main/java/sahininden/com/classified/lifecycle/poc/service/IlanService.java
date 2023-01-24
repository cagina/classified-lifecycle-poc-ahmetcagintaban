package sahininden.com.classified.lifecycle.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sahininden.com.classified.lifecycle.poc.entity.Ilan;
import sahininden.com.classified.lifecycle.poc.enums.IlanCategory;
import sahininden.com.classified.lifecycle.poc.enums.IlanStatus;
import sahininden.com.classified.lifecycle.poc.model.IlanRequestModel;
import sahininden.com.classified.lifecycle.poc.model.IlanResponseModel;
import sahininden.com.classified.lifecycle.poc.repository.IlanRepository;
import sahininden.com.classified.lifecycle.poc.utils.StringOperator;

import java.util.ArrayList;
import java.util.List;

@Service
public class IlanService {
	@Autowired
	IlanRepository ilanRepository;
	@Autowired
	StringOperator stringOperator;

	public void InsertData(IlanRequestModel req) throws Exception {
		IlanCategory vlu = stringOperator.findByIlanCategoryEnumValue(req.getCategory());
		if(stringOperator.containWords(req.getTitle().split(" ")))
			throw new Exception();
		else if( vlu == null){
			throw new Exception();
		} else if(stringOperator.containWords(req.getDescription().split(" "))){
			throw new Exception();
		} else {
			ilanRepository.save(new Ilan(req.getTitle(), req.getDescription(),
					vlu, IlanStatus.ONAYDA));
		}
	}

	public List<IlanResponseModel> getDataAlls() {
		List<IlanResponseModel> res = new ArrayList<>();
		ilanRepository.findAll().forEach((ilan) -> {
		res.add(new IlanResponseModel(ilan.getTitle(), ilan.getDescription(), ilan.getCategory().getValue(), ilan.getStatus().getValue(), ilan.getId()));
		});
		return res;
	}
}
