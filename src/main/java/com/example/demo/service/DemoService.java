package com.example.demo.service;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.util.HttpRestClient;

@Service
public class DemoService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HttpRestClient restClient;

	public JSONArray getForcast(String cityName) {
		this.LOGGER.info("Service:getForcast called with cityName:  "+cityName);
		JSONArray response = this.restClient.getAPIData(cityName);
		this.LOGGER.info("Service:getForcast successfully return data with cityName:  "+cityName);
		return response;
		
	}

}
