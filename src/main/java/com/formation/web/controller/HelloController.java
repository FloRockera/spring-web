package com.formation.web.controller;

import java.text.MessageFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/healthcheck")
public class HelloController {

	@GetMapping("/simple")
	@ResponseBody
	public String simple() {
		return "Ok!";
	}

	@GetMapping("/variable/{user}")
	@ResponseBody
	public String variable(@PathVariable String user) {
		return MessageFormat.format("Hi {0}", user);
	}

}