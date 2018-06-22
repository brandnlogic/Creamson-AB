package com.bnl.creamson.ptm.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value={"messageType","messageCode", "message"})
public class Message {

	private String messageType;
	private Integer messageCode;
	private String message;

	public Message(String messageType, Integer messageCode, String message) {
		this.message = message;
		this.messageCode = messageCode;
		this.messageType= messageType;
	}

	public Integer getMessageCode() {
		return messageCode;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageType() {
		return messageType;
	}
}
