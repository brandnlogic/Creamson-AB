package com.bnl.creamson.ptm.enums;

public enum RequestGroup {

	Individual('I'),
	All('A');

	private char dbValue; 
	
	private RequestGroup(char dbValue) {
		this.dbValue = dbValue;
	}
	
	public char getDbValue() {
		return this.dbValue;
	}
	
	
}
