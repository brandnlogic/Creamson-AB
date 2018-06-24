package com.bnl.creamson.ptm.converter;

import javax.persistence.AttributeConverter;

import com.bnl.creamson.ptm.enums.RequestGroup;

public class RequestGroupEntityDataConverter implements AttributeConverter<RequestGroup, Character> {

	/**
	 * Convert Color object to a String with format red|green|blue|alpha
	 */
	@Override
	public Character convertToDatabaseColumn(RequestGroup group) {
		return group.getDbValue();
	}

	/**
	 * Convert a String with format red|green|blue|alpha to a Color object
	 */
	@Override
	public RequestGroup convertToEntityAttribute(Character groupDB) {
		for (RequestGroup group:RequestGroup.values()){
			if(group.getDbValue() == groupDB)
				return group;
		}
		throw new RuntimeException("Group record not found");
	}

}
