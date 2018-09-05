package com.formation.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbc.MessageDto;

public class MessageMapper<T> implements RowMapper {
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		MessageDto message = new MessageDto();
		message.setIdmessage(rs.getInt("idmessage"));
		message.setFromUser(rs.getString("fromUser"));
		message.setToUser(rs.getString("toUser"));
		message.setContent(rs.getString("content"));
		message.setEventTime(rs.getTimestamp("event_Time").toLocalDateTime());
		return (T) message;
	}
}