package com.bnl.creamson.ptm.enums;

public enum NotificationType {

	Mail('M'),
	Mobile('A');
	
	private Character dbValue;
	private NotificationType(Character dbValue){
		this.dbValue= dbValue;
	}
	
	public Character getDbValue() {
		return dbValue;
	}
}
