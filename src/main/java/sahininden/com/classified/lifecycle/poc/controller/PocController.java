package sahininden.com.classified.lifecycle.poc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import sahininden.com.classified.lifecycle.poc.entity.LongestRequestLog;
import sahininden.com.classified.lifecycle.poc.model.*;
import sahininden.com.classified.lifecycle.poc.service.IlanService;

import java.util.List;

@RestController
@RequestMapping("api/poc")
@Api(value = "Ilan API Dökümantasyonu")
public class PocController {
	@Autowired
	IlanService ilanService;
	@GetMapping("/dashboard/classifieds/statistics")
	@ApiOperation(value="İstatistikleri döner")
	public StatisticsResponse getAllStatisticsData() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		StatisticsResponse res = ilanService.getDataAlls();
		stopWatch.stop();
		if (stopWatch.getTotalTimeMillis() > 5)
			ilanService.longRequestLogSaver(new LongestRequestLog("", res.toString(), stopWatch.getTotalTimeMillis(),"getAllStatisticsData"));
		return res;
	}
	@PostMapping("/insert")
	@ApiOperation(value="İlan ekler")
	public void insertIlan(@RequestBody IlanRequestModel model) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		try {
			ilanService.InsertData(model);
		} catch (Exception e) {
			stopWatch.stop();
			if (stopWatch.getTotalTimeMillis() > 5)
				ilanService.longRequestLogSaver(new LongestRequestLog(model.toString(), HttpStatus.BAD_REQUEST.toString(), stopWatch.getTotalTimeMillis(),"insertIlan"));
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid format");
		}
		stopWatch.stop();
		if (stopWatch.getTotalTimeMillis() > 5)
			ilanService.longRequestLogSaver(new LongestRequestLog(model.toString(), "200 OK", stopWatch.getTotalTimeMillis(),"insertIlan"));
	}
	@PutMapping("/update/ilan")
	@ApiOperation(value="İlan günceller")
	public void updateIlan(@RequestBody IlanUpdateRequestModel model) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		ilanService.updateIlan(model);
		stopWatch.stop();
		if (stopWatch.getTotalTimeMillis() > 5)
			ilanService.longRequestLogSaver(new LongestRequestLog(model.toString(), "", stopWatch.getTotalTimeMillis(),"updateIlan"));
	}

	@GetMapping("/onay/list")
	@ApiOperation(value="Onayda bekleyen ilanların listesini döner")
	public List<IlanResponseModel> getOnayList() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		List<IlanResponseModel> res = ilanService.getOnayList();
		stopWatch.stop();
		if (stopWatch.getTotalTimeMillis() > 5)
			ilanService.longRequestLogSaver(new LongestRequestLog("", res.toString(), stopWatch.getTotalTimeMillis(),"getOnayList"));
		return res;
	}

	@GetMapping("/logIlanList/list")
	@ApiOperation(value="İlanda değişim olan bütün ilanları döner.")
	public List<LogIlanReponseModel> getlogIlanList() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		List<LogIlanReponseModel>  res = ilanService.getlogIlanList();
		stopWatch.stop();
		if (stopWatch.getTotalTimeMillis() > 5)
			ilanService.longRequestLogSaver(new LongestRequestLog("", res.toString(), stopWatch.getTotalTimeMillis(),"getlogIlanList"));
		return res;
	}

	@PostMapping("/ilan/history")
	@ApiOperation(value="Seçili ilanda olan bütün değişiklikleri döner")
	public List<LogIlanReponseModel> getOneRecordLogIlan(@RequestBody IlanIdModel model) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		List<LogIlanReponseModel> res = ilanService.getOneRecordLogIlan(model);
		stopWatch.stop();
		if (stopWatch.getTotalTimeMillis() > 5)
			ilanService.longRequestLogSaver(new LongestRequestLog(model.toString(), res.toString(), stopWatch.getTotalTimeMillis(),"getOneRecordLogIlan"));
		return res;
	}

	@GetMapping("/logRequestResponse/list")
	@ApiOperation(value="5 ms uzun süren responseları loglarını döner.")
	public List<LongestResponseLogModel> getLogRequestResponse() {
		return ilanService.getLogRequestResponse();
	}
}
