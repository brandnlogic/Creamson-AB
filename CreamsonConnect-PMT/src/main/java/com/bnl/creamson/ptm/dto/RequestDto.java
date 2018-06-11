package com.bnl.creamson.ptm.dto;

public class RequestDto {

	private MeetingDetlDto meetingDetl;

	public MeetingDetlDto getMeetingDetl() {
		return meetingDetl;
	}

	public void setMeetingDetl(MeetingDetlDto meetingDetl) {
		this.meetingDetl = meetingDetl;
	}
	
	//https://auth0.com/blog/automatically-mapping-dto-to-entity-on-spring-boot-apis/
	//http://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
	//https://www.thoughts-on-java.org/jpa-21-how-to-implement-type-converter/

}
