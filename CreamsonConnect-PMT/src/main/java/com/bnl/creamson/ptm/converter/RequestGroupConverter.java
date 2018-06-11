package com.bnl.creamson.ptm.converter;

import javax.persistence.AttributeConverter;

import com.bnl.creamson.ptm.enums.RequestGroup;

public class RequestGroupConverter implements AttributeConverter<RequestGroup, String> {

	/**
	 * Convert Color object to a String with format red|green|blue|alpha
	 */
	@Override
	public String convertToDatabaseColumn(RequestGroup group) {
		return group.getDbValue();
	}

	/**
	 * Convert a String with format red|green|blue|alpha to a Color object
	 */
	@Override
	public RequestGroup convertToEntityAttribute(String groupDB) {
		for (RequestGroup group:RequestGroup.values()){
			if(group.getDbValue().equals(groupDB))
				return group;
		}
		throw new RuntimeException("Group record not found");
	}

}
