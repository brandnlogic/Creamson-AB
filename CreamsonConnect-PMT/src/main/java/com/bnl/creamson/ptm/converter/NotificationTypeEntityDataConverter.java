package com.bnl.creamson.ptm.converter;

import javax.persistence.AttributeConverter;

import com.bnl.creamson.ptm.enums.NotificationType;

public class NotificationTypeEntityDataConverter implements AttributeConverter<NotificationType, Character>{

	@Override
	public Character convertToDatabaseColumn(NotificationType group) {
		return group.getDbValue();
	}

	@Override
	public NotificationType convertToEntityAttribute(Character groupDB) {
		for (NotificationType group:NotificationType.values()){
			if(group.getDbValue() == groupDB)
				return group;
		}
		throw new RuntimeException("Notification type not found");
	}

}
