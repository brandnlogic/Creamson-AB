package com.bnl.creamson.ptm.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.bnl.creamson.ptm.enums.MeetingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	private Integer createdById;

	@JsonProperty(required = true)
	@JsonFormat(pattern = "DD/MM/YYYY")
	private Date startDate;

	@JsonProperty(required = true)
	@JsonFormat(pattern = "DD/MM/YYYY")
	private Date endDate;

	@JsonProperty(required = true)
	@JsonFormat(pattern = "24HH:MM")
	private Time startTime;

	@JsonProperty(required = true)
	@JsonFormat(pattern = "24HH:MM")
	private Time endTime;

	private String notificationId;

	private String location;

	private String subject;

	@JsonFormat()
	private String description;

	private MeetingStatus meetingStatus;

	private String lastUpdateBy;

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

	public Integer getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Integer createdById) {
		this.createdById = createdById;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
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

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
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

}
