package com.bnl.creamson.ptm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bnl.creamson.ptm.converter.NotificationStatusEntityDataConverter;
import com.bnl.creamson.ptm.converter.RequestGroupEntityDataConverter;
import com.bnl.creamson.ptm.enums.NotificationStatus;
import com.bnl.creamson.ptm.enums.NotificationType;
import com.bnl.creamson.ptm.enums.RequestGroup;

/**
 * The persistent class for the NOTIFICATION_TRACKING_DTLS database table.
 * 
 */
@Entity
@Table(name = "NOTIFICATION_TRACKING_DTLS")
@NamedQuery(name = "NotificationTrackingDtl.findAll", query = "SELECT n FROM NotificationTrackingDtl n")
public class NotificationTrackingDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NOTIFICATION_TRACKING_ID")
	private int notificationTrackingId;

	@Column(name = "`GROUP`")
	@Convert(converter = RequestGroupEntityDataConverter.class)
	private RequestGroup group;

	@Column(name = "GROUP_ID")
	private int groupId;

	@Column(name = "LAST_UPDATE_ID")
	private String lastUpdateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_TIMESTAMP")
	private Date lastUpdateTimestamp;

	@Column(name = "NOTIFICATION_STATUS")
	@Convert(converter = NotificationStatusEntityDataConverter.class)
	private NotificationStatus notificationStatus;

	@Column(name = "NOTIFICATION_TYPE")
	@Enumerated
	private NotificationType notificationType;

	@ManyToOne
	@JoinColumn(columnDefinition = "MEETING_ID", referencedColumnName = "meetingId", nullable = false)
	private MeetingDtl meetingDtl;

	public NotificationTrackingDtl() {
	}

	public int getNotificationTrackingId() {
		return this.notificationTrackingId;
	}

	public void setNotificationTrackingId(int notificationTrackingId) {
		this.notificationTrackingId = notificationTrackingId;
	}

	public RequestGroup getGroup() {
		return group;
	}

	public void setGroup(RequestGroup group) {
		this.group = group;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getLastUpdateId() {
		return this.lastUpdateId;
	}

	public void setLastUpdateId(String lastUpdateId) {
		this.lastUpdateId = lastUpdateId;
	}

	public Date getLastUpdateTimestamp() {
		return this.lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public MeetingDtl getMeetingDtl() {
		return meetingDtl;
	}

	public void setMeetingDtl(MeetingDtl meetingDtl) {
		this.meetingDtl = meetingDtl;
	}

	public NotificationStatus getNotificationStatus() {
		return this.notificationStatus;
	}

	public void setNotificationStatus(NotificationStatus notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public NotificationType getNotificationType() {
		return this.notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

}