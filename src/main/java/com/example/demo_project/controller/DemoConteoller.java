package com.example.demo_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoConteoller {
	
	@GetMapping(value = "/hello")
	public String hello(@RequestParam(name = "name", required= false, defaultValue= "world")String name, Model model) {
		model.addAttribute("name", name);
		return "hello.html";
	}
}
