package com.bnl.creamson.ptm.enums;

public enum RequestGroup {

	Individual("I"),
	All("A");

	private String dbValue; 
	
	private RequestGroup(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String getDbValue() {
		return dbValue;
	}
	
	
}
