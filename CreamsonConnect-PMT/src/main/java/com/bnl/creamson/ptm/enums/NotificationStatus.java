package com.bnl.creamson.ptm.enums;

public enum NotificationStatus {

	Delivered(200),
	NotStarted(201),
	Failed(301);
	
	private Integer statusCode;
	private NotificationStatus(Integer statusCode){
		this.statusCode = statusCode;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	
}
