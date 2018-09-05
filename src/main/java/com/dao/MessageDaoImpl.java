package com.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jdbc.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	@PersistenceContext
	public EntityManager em;

	@Override
	public void save(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String toUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Message oldMessage, String newContent, LocalDateTime newEventTime) {
		// TODO Auto-generated method stub

	}

}
