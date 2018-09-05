package com.formation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.formation.service.IMessageService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IMessageService serv;

	@GetMapping("/messages")
	public ModelAndView ListWithMessage() {
		ModelAndView modelAndView = new ModelAndView();

		// List<MessageDto> messages = new ArrayList<>();
		//
		// MessageDto message1 = new MessageDto();
		// message1.setFromUser("Vincent");
		// message1.setToUser("Lena");
		// message1.setContent("Salut Lena");
		// message1.setEventTime(LocalDateTime.now());
		//
		// messages.add(message1);

		modelAndView.addObject("messages", serv.findAllMessages());
		modelAndView.setViewName("list");
		return modelAndView;
	}

	@GetMapping("/messages/new")
	public ModelAndView CreateMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("create_message");
		return modelAndView;
	}

}
