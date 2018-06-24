package com.bnl.creamson.ptm.application;

/**
 * 
 * @author liveyoung
 * This enum contain message related to application.
 * 
 * Message type - Information, Confirmation, Warning, Error, System
 */
public enum ApplicationMessage {

	METTING_CONFLICT_WARNING_MESSAGE(3001, "Warning", "There a conflict in meeting schedule."),
	METTING_CREATTION_MESSAGE(3002,"Confirmation", "Meeting has beed scheduled."),
	INSTITUTION_ID(3003,"Error", "Institution ID cannot be null");

	private Integer messageCode;
	private String message;
	private String messageType;

	private ApplicationMessage(Integer messageCode, String messageType, String message) {
		this.messageCode = messageCode;
		this.message = message;
		this.messageType = messageType;

	}
	
	public String getMessage() {
		return message;
	}
	
	public Integer getMessageCode() {
		return messageCode;
	}
	
	public String getMessageType() {
		return messageType;
	}

}
