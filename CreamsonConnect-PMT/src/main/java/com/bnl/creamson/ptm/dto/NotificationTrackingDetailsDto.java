package com.bnl.creamson.ptm.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.bnl.creamson.ptm.enums.MeetingAcceptStatus;
import com.bnl.creamson.ptm.enums.NotificationStatus;
import com.bnl.creamson.ptm.enums.NotificationType;
import com.bnl.creamson.ptm.enums.RequestGroup;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationTrackingDetailsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2789663669283866586L;

	@NotNull
	private NotificationType notificationType;
	
	@JsonProperty(defaultValue="NotStarted")
	private NotificationStatus notificationStatus;
	
	@NotNull
	private RequestGroup group;
	private Long groupId;
	
	
	@JsonProperty(defaultValue="Accept")
	private MeetingAcceptStatus meetingAcceptStatus;

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

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public MeetingAcceptStatus getMeetingAcceptStatus() {
		return meetingAcceptStatus;
	}

	public void setMeetingAcceptStatus(MeetingAcceptStatus meetingAcceptStatus) {
		this.meetingAcceptStatus = meetingAcceptStatus;
	}

}
