package sahininden.com.classified.lifecycle.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sahininden.com.classified.lifecycle.poc.model.IlanRequestModel;
import sahininden.com.classified.lifecycle.poc.model.IlanResponseModel;
import sahininden.com.classified.lifecycle.poc.service.IlanService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api/poc")
public class PocController {
	@Autowired
	IlanService ilanService;
	@GetMapping()
	public List<IlanResponseModel> getAll() {
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
}
