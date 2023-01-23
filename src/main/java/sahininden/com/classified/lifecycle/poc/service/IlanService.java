package sahininden.com.classified.lifecycle.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sahininden.com.classified.lifecycle.poc.entity.Ilan;
import sahininden.com.classified.lifecycle.poc.model.IlanRequestModel;
import sahininden.com.classified.lifecycle.poc.model.IlanResponseModel;
import sahininden.com.classified.lifecycle.poc.repository.IlanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IlanService {
	@Autowired
	IlanRepository ilanRepository;

	public void InsertData(IlanRequestModel req) {
		ilanRepository.save(new Ilan(req.getTitle(), req.getDescription(),
				req.getCategory(), req.getStatus()));
	}

	public List<IlanResponseModel> getDataAlls() {
		List<IlanResponseModel> res = new ArrayList<>();
		ilanRepository.findAll().forEach((ilan) -> {
		res.add(new IlanResponseModel(ilan.getTitle(), ilan.getDescription(), ilan.getCategory(), ilan.getStatus(), ilan.getId()));
		});
		return res;
	}
}
