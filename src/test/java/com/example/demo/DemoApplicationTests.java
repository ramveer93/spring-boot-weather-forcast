package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.DemoController;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	
	@Autowired
	private DemoController demoController;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void contextLoads() {
		assertThat(demoController).isNotNull();
	}
	
	@Test
	public void shouldReturnBadRequest() throws Exception {
		this.mockMvc.perform(get("/v1/weather/getForcast")).andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldReturnBadRequestWhenInvalidCityName() throws Exception {
		this.mockMvc.perform(get("/v1/weather/getForcast?cityName=xyz")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnValidResponse() throws Exception {
		this.mockMvc.perform(get("/v1/weather/getForcast?cityName=Jaipur")).andDo(print()).andExpect(status().isOk());
	}

}
