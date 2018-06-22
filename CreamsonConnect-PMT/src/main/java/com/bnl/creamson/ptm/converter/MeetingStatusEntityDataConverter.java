package com.bnl.creamson.ptm.converter;

import javax.persistence.AttributeConverter;

import com.bnl.creamson.ptm.enums.MeetingStatus;

public class MeetingStatusEntityDataConverter implements AttributeConverter<MeetingStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(MeetingStatus arg0) {
		return arg0.getStatusId();
	}

	@Override
	public MeetingStatus convertToEntityAttribute(Integer statusId) {
		for (MeetingStatus meetingStatus:MeetingStatus.values()){
			if(meetingStatus.getStatusId() == statusId)
				return meetingStatus;
		}
		throw new RuntimeException("Status not found");
	}

	

} 
