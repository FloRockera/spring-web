package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/healthcheck")
public class HelloController {

	@GetMapping("/")
	@ResponseBody
	public String simple() {
		return "Ok!";
	}

	@GetMapping("/")
	@ResponseBody
	public String variable() {
		return ("Hi");
	}

}
