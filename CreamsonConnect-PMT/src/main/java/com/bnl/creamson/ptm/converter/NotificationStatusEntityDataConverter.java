package com.bnl.creamson.ptm.converter;

import javax.persistence.AttributeConverter;

import com.bnl.creamson.ptm.enums.NotificationStatus;

public class NotificationStatusEntityDataConverter implements AttributeConverter<NotificationStatus, Integer>{

	@Override
	public Integer convertToDatabaseColumn(NotificationStatus arg0) {
		return arg0.getStatusCode();
	}

	@Override
	public NotificationStatus convertToEntityAttribute(Integer arg0) {
		for (NotificationStatus group:NotificationStatus.values()){
			if(group.getStatusCode().equals(arg0))
				return group;
		}
		return NotificationStatus.Failed;
	}

	
}
