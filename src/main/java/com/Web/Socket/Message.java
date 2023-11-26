package com.Web.Socket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	private String messageContent;

	public String getMessageContent() {
		return messageContent;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	

}
