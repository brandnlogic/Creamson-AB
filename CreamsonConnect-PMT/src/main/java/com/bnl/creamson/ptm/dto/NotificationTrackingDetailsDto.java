package com.bnl.creamson.ptm.dto;

import java.io.Serializable;

import com.bnl.creamson.ptm.enums.NotificationStatus;
import com.bnl.creamson.ptm.enums.NotificationType;
import com.bnl.creamson.ptm.enums.RequestGroup;

public class NotificationTrackingDetailsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2789663669283866586L;
	
	private NotificationType notificationType;
	private NotificationStatus notificationStatus;
	private RequestGroup group;
	private Integer groupId;

	public NotificationStatus getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(NotificationStatus notificationStatus) {
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

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

}
