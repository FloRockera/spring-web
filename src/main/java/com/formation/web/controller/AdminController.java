package com.formation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formation.service.IMessageService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IMessageService serv;

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ModelAndView directWithMessage() {
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

		modelAndView.setViewName("list");
		modelAndView.addObject("messages", serv.findAllMessages());
		return modelAndView;
	}

	@RequestMapping(value = "/messages/new", method = RequestMethod.GET)
	public ModelAndView coucou() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("create_message");
		// modelAndView.addObject("messages", serv.findAllMessages());
		return modelAndView;
	}

}
