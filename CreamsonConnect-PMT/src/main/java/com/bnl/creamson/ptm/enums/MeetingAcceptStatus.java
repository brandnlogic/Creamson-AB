package com.bnl.creamson.ptm.enums;

public enum MeetingAcceptStatus {

	Accept('A'),
	Deny('D');
	
	private Character dbValue;
	private MeetingAcceptStatus(Character dbValue){
		this.dbValue = dbValue;
	}
	
	public Character getDbValue() {
		return dbValue;
	}
}
