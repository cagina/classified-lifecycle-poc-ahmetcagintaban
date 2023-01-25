package sahininden.com.classified.lifecycle.poc.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sahininden.com.classified.lifecycle.poc.model.StatisticsResponse;
import sahininden.com.classified.lifecycle.poc.model.IlanRequestModel;
import sahininden.com.classified.lifecycle.poc.model.IlanUpdateRequestModel;
import sahininden.com.classified.lifecycle.poc.model.IlanResponseModel;
import sahininden.com.classified.lifecycle.poc.model.LogIlanReponseModel;
import sahininden.com.classified.lifecycle.poc.model.IlanIdModel;
import sahininden.com.classified.lifecycle.poc.service.IlanService;

import java.util.List;

@RestController
@RequestMapping("api/poc")
@Api(value = "Post API Dökümantasyonu")
public class PocController {
	@Autowired
	IlanService ilanService;
	@GetMapping("/dashboard/classifieds/statistics")
	public StatisticsResponse getAll() {
		return ilanService.getDataAlls();
	}

	@PostMapping("/insert")
	public void insertIlan(@RequestBody IlanRequestModel model) {
		try {
			ilanService.InsertData(model);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid format");
		}
	}

	@PutMapping("/update/ilan")
	public void updateIlan(@RequestBody IlanUpdateRequestModel model) {
		ilanService.updateIlan(model);
	}

	@GetMapping("/onay/list")
	public List<IlanResponseModel> getOnayList() {
		return ilanService.getOnayList();
	}

	@GetMapping("/logIlanList/list")
	public List<LogIlanReponseModel> getlogIlanList() {
		return ilanService.getlogIlanList();
	}

	@PostMapping("/ilan/history")
	public List<LogIlanReponseModel> getOneRecordLogIlan(@RequestBody IlanIdModel model) {
		return ilanService.getOneRecordLogIlan(model);
	}


}
