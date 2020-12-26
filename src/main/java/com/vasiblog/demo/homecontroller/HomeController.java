package com.vasiblog.demo.homecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView home_model = new ModelAndView();
		System.out.println("Home Page is hit");
		home_model.setViewName("homePage");
		return home_model;
	}
	
	@RequestMapping("/homeNavigation")
	public ModelAndView homeMain() {
		ModelAndView home_model = new ModelAndView();
		home_model.setViewName("homePage");
		return home_model;
	}
}
