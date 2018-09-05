package com.formation.web.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.formation.jdbc.MessageDto;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/messages")
	public ModelAndView ListWithMessage() {
		ModelAndView modelAndView = new ModelAndView();

		List<MessageDto> messages = new ArrayList<>();

		MessageDto message1 = new MessageDto();
		message1.setFromUser("Vincent");
		message1.setToUser("Lena");
		message1.setContent("Salut Lena");
		message1.setEventTime(LocalDateTime.now());

		messages.add(message1);

		modelAndView.addObject("messages", messages);
		modelAndView.setViewName("list");
		return modelAndView;

		// Autre méthode
		// @GetMapping("/messages")
		// public String listModel(Model model) {
		//
		// List<MessageDto> messages = new ArrayList<>();
		//
		// MessageDto message1 = new MessageDto();
		// message1.setFromUser("Vincent");
		// message1.setToUser("Lena");
		// message1.setContent("Salut Lena");
		// message1.setEventTime(LocalDateTime.now());
		//
		// messages.add(message1);
		//
		// model.addAttribute("messages", messages);
		// return "list";
	}

}
