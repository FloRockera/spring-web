package com.formation.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.model.MessageDto;
import com.formation.service.IMessageService;

@RestController
@RequestMapping("/admin")
public class RestAppController {

	@Autowired
	IMessageService serv;

	@RequestMapping(value = "/messages", produces = { "application/JSON" })
	public List<MessageDto> getMessages() {
		return serv.findAllMessages();
	}

}
