package com.bnl.creamson.ptm.converter;

import javax.persistence.AttributeConverter;

import com.bnl.creamson.ptm.enums.MeetingAcceptStatus;

public class MeetingAcceptEntityDataConverter implements AttributeConverter<MeetingAcceptStatus, Character> {

	/**
	 * Convert Color object to a String with format red|green|blue|alpha
	 */
	@Override
	public Character convertToDatabaseColumn(MeetingAcceptStatus group) {
		return group.getDbValue();
	}

	/**
	 * Convert a String with format red|green|blue|alpha to a Color object
	 */
	@Override
	public MeetingAcceptStatus convertToEntityAttribute(Character groupDB) {
		for (MeetingAcceptStatus group:MeetingAcceptStatus.values()){
			if(group.getDbValue() == groupDB)
				return group;
		}
		throw new RuntimeException("Group record not found");
	}

}
