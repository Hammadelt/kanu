package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("mainpage")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "User") String name, Map<String, Object> model) {
		model.put("name", name);
		return "mainpage";
	}

}
