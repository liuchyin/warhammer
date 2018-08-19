package com.marc.warhammer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marc.warhammer.service.WarHammerService;

import org.springframework.http.HttpStatus;
@RestController
@RequestMapping(value = "/wh")
@EnableAutoConfiguration
public class WarHammerController {
	
	@Autowired
	WarHammerService warHammerService;
	
	@RequestMapping(value = {"getAnalysisTask"}, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> testLock(){
		ResponseEntity<Object> res = new ResponseEntity<Object>("helloworld", HttpStatus.OK);
		return res;
	}
	
	
	@RequestMapping(value = {"lockTables"}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> lockTables(String id){
		warHammerService.joinWithLockAllTable(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("success");
	}
	
	@RequestMapping(value = {"lockOneTable"}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> lockOneTable(String id){
		warHammerService.joinWithLockOneTable(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("success");
	}
	
}
