package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoViewController {

	@RequestMapping("/index")
	public ModelAndView indexTest() {
		System.out.println("inside index view .....");
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("index");
		return modelView;
	}
}
