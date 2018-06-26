package com.bnl.creamson.ptm.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bnl.creamson.ptm.enums.MeetingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetingDetlDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 785687176137201974L;

	@JsonProperty(defaultValue = "false")
	private boolean acceptConflict;

	@JsonProperty(required = true)
	private Integer institutionId;

	@JsonProperty(required = true)
	private Integer teacherId;

	@JsonProperty(required = true)
	private String createdBy;

	@JsonProperty(required = true)
	@JsonFormat(shape = Shape.STRING)
	private LocalDateTime startDate;

	@JsonProperty(required = true)
	@JsonFormat(shape = Shape.STRING)
	private LocalDateTime endDate;

	private String notificationId;

	private String location;

	private String subject;

	private String description;

	@JsonProperty(defaultValue="Active")
	private MeetingStatus meetingStatus;

	@JsonProperty(value = "LastUpdatedBy")
	private String lastUpdate;

	private Integer setByUserId;

	private List<NotificationTrackingDetailsDto> notificationDetails;

	public Integer getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdById) {
		this.createdBy = createdById;
	}

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MeetingStatus getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(MeetingStatus meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	public List<NotificationTrackingDetailsDto> getNotificationDetails() {
		return notificationDetails;
	}

	public void setNotificationDetails(List<NotificationTrackingDetailsDto> notificationDetails) {
		this.notificationDetails = notificationDetails;
	}

	public boolean isAcceptConflict() {
		return acceptConflict;
	}

	public void setAcceptConflict(boolean acceptConflict) {
		this.acceptConflict = acceptConflict;
	}

	public Integer getSetByUserId() {
		return setByUserId;
	}

	public void setSetByUserId(Integer setByUserId) {
		this.setByUserId = setByUserId;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdateId) {
		this.lastUpdate = lastUpdateId;
	}

}
