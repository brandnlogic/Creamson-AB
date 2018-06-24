package com.bnl.creamson.ptm.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bnl.creamson.ptm.converter.MeetingStatusEntityDataConverter;
import com.bnl.creamson.ptm.enums.MeetingStatus;

/**
 * The persistent class for the MEETING_DTLS database table.
 * 
 */
@Entity
@Table(name = "MEETING_DTLS")
@NamedQuery(name = "MeetingDtl.findAll", query = "SELECT m FROM MeetingDtl m")
public class MeetingDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEETING_ID")
	private Long meetingId;

	@Column(name = "TEACHER_ID")
	private int teacherId;

	@Column(name = "INSTITUTION_ID")
	private int institutionId;

	@Column(name = "NOTIFICATION_ID")
	private String notificationId;

	@Column(name = "SET_BY_USER_ID")
	private int setByUserId;

	@Column(name = "START_DATE")
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	private LocalDateTime endDate;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "MEETING_STATUS")
	@Convert(converter = MeetingStatusEntityDataConverter.class)
	private MeetingStatus meetingStatus;

	@Column(name = "CREATED_BY_ID")
	private String createdBy;

	@Column(name = "CREATED_TIMESTAMP")
	private LocalDateTime createdTimestamp;

	@Column(name = "LAST_UPDATE_ID")
	private String lastUpdate;

	@Column(name = "LAST_UPDATE_TIMESTAMP")
	private LocalDateTime lastUpdateTimestamp;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meetingDtl")
	private List<NotificationTrackingDtl> notificationDetails;

	public MeetingDtl() {
	}

	public Long getMeetingId() {
		return this.meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public int getInstitutionId() {
		return this.institutionId;
	}

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}

	public String getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(String lastUpdateId) {
		this.lastUpdate = lastUpdateId;
	}

	public LocalDateTime getLastUpdateTimestamp() {
		return this.lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(LocalDateTime lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public MeetingStatus getMeetingStatus() {
		return this.meetingStatus;
	}

	public void setMeetingStatus(MeetingStatus meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	public String getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public int getSetByUserId() {
		return this.setByUserId;
	}

	public void setSetByUserId(int setByUserId) {
		this.setByUserId = setByUserId;
	}

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdById) {
		this.createdBy = createdById;
	}
	
	public List<NotificationTrackingDtl> getNotificationDetails() {
		return notificationDetails;
	}
	
	public void setNotificationDetails(List<NotificationTrackingDtl> notificationDetails) {
		this.notificationDetails = notificationDetails;
	}
	
	public void addNotificationDetails(NotificationTrackingDtl notificationDetail){
		if(this.notificationDetails == null){
			this.notificationDetails = new ArrayList<NotificationTrackingDtl>();
		}
		this.notificationDetails.add(notificationDetail);
	}

}