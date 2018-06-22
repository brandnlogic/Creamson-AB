package com.bnl.creamson.ptm.enums;

/**
 * It denote meeting status
 * @author liveyoung
 *
 */
public enum MeetingStatus {

	Active(1), Deactive(2);

	private Integer statusId;

	private MeetingStatus(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getStatusId() {
		return statusId;
	}
}
