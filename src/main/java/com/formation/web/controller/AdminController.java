package com.formation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formation.model.MessageDto;
import com.formation.service.IMessageService;
import com.formation.web.validator.MessageValidator;

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
	public ModelAndView showCreationForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("create_message");
		modelAndView.addObject("message", new MessageDto());
		return modelAndView;
	}

	// Pour enregistrer le validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new MessageValidator());
	}

	// Traitement de soumission
	@PostMapping("/messages/new")
	public String submitCreation(@Validated @ModelAttribute("message") MessageDto message, BindingResult result) {
		if (result.hasErrors()) {
			return "create_message";
		}
		System.out.println("Enregistre le message " + message.getFromUser() + " " + message.getToUser() + " "
				+ message.getContent());
		return "list";

	}
}
