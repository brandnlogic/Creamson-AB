package com.bnl.creamson.ptm.dto;

import java.util.List;

public class ResponseDto<T> {

	private List<Message> message;

	private T payload;

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	public T getPayload() {
		return payload;
	}
	
	public void setPayload(T payload) {
		this.payload = payload;
	}

}
