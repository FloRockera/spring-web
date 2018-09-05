package com.jdbc;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@Column(name = "idmessage")
	private int idmessage;

	@Column(name = "fromUser")
	private String fromUser;

	@Column(name = "toUser")
	private String toUser;

	@Column(name = "content")
	private String content;

	@Column(name = "event_time")
	private LocalDateTime eventTime;

	public Message(String fromUser2, String toUser2, String content2) {
		// TODO Auto-generated constructor stub
	}

	// Methode toString
	@Override
	public String toString() {
		return "Message [idmessage=" + idmessage + ", fromUser=" + fromUser + ", toUser=" + toUser + ", content="
				+ content + ", eventTime=" + eventTime + "]";
	}

	// Getters et setters
	public int getIdmessage() {
		return idmessage;
	}

	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}

}
