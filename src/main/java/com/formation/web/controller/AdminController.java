package com.formation.web.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.jdbc.MessageDto;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/messages")
	public String listModel(Model model) {

		List<MessageDto> messages = new ArrayList<>();

		MessageDto message1 = new MessageDto();
		message1.setFromUser("exp");
		message1.setToUser("dest");
		message1.setContent("hello");
		message1.setEventTime(LocalDateTime.now());
		messages.add(message1);

		model.addAttribute("messages", messages);
		return "list";
	}

}
