package com.formation.dao;

import java.time.LocalDateTime;

import com.formation.entity.Message;

public interface MessageDao {

	public void save(Message message);

	void delete(String fromUser, String toUser);

	void modify(Message oldMessage, String newContent, LocalDateTime newEventTime);

}
