package com.bnl.creamson.ptm.dto;

import java.io.Serializable;

import com.bnl.creamson.ptm.enums.RequestGroup;

public class NotificationTrackingDetailsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2789663669283866586L;
	
	private String notificationType;
	private Integer notificationStatus;
	private RequestGroup group;
	private Integer groupId;

	public Integer getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(Integer notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public RequestGroup getGroup() {
		return group;
	}

	public void setGroup(RequestGroup group) {
		this.group = group;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

}
