package com.example.demo.controller;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;
import com.example.demo.util.WeatherAppException;

@Component
@RestController
@RequestMapping(value = "/v1/weather")
public class DemoController {

	@Autowired
	private DemoService service;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/getForcast", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getForcast(@RequestParam(value = "cityName") String cityName) {
		this.LOGGER.info("getForcast called with cityName: "+cityName);
		JSONArray result = null;
		try {
			result = this.service.getForcast(cityName);
			System.out.println(result.toString());
			this.LOGGER.info("getForcast successfully got resullt for city: "+cityName+" and result is : "+result.toString());
		} catch (WeatherAppException e) {
			this.LOGGER.error("getForcast Error getting data :  "+e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(result.toString(), HttpStatus.OK);
	}
}
