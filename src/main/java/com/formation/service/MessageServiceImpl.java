package com.formation.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.MessageDao;
import com.formation.entity.Message;
import com.formation.model.MessageDto;
import com.formation.repository.MessageRepository;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

	@Autowired
	MessageDao dao;

	@Autowired
	MessageRepository repository;

	@Override
	public void send(MessageDto message) {
		Message newMessage = new Message(message.getFromUser(), message.getToUser(), message.getContent());
		dao.save(newMessage);

	}

	@Override
	public void edit(MessageDto editedMsg) {
		Message editeMessage = new Message(editedMsg.getFromUser(), editedMsg.getToUser(), editedMsg.getContent());
		dao.save(editeMessage);

	}

	@Override
	public void delete(String fromUser, String toUser) {
		dao.delete(fromUser, toUser);
	}

	@Override
	public List<MessageDto> findAllMessages() {
		List<Message> messages = repository.findAll();
		return messages.stream().map(e -> {
			return fromMessageToMessageDto(e);
		}).collect(Collectors.toList());
	}

	@Override
	public List<MessageDto> findMessageSendToAUserADay(String toUser, LocalDate day) {
		// List<Message> messages =
		// repository.findByToUserAndEventTimeBetween(toUser, day,
		// LocalDate.now());
		// return messages.stream().map(e -> {
		// return fromMessageToMessageDto(e);
		// }).collect(Collectors.toList());
		return null;
	}

	@Override
	public List<MessageDto> findAllMessageFromUser(String fromUser) {
		List<Message> messages = repository.findByFromUser(fromUser);
		List<MessageDto> messagesDto = new ArrayList<MessageDto>();
		for (Message message : messages) {
			messagesDto.add(fromMessageToMessageDto(message));
		}
		return messagesDto;
	}

	private MessageDto fromMessageToMessageDto(Message message) {
		MessageDto newMessageDto = new MessageDto();
		newMessageDto.setFromUser(message.getFromUser());
		newMessageDto.setToUser(message.getToUser());
		newMessageDto.setContent(message.getContent());
		newMessageDto.setEventTime(message.getEventTime());
		return newMessageDto;
	}

}
