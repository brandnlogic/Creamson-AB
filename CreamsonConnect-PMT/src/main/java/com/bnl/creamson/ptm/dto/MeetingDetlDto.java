package com.bnl.creamson.ptm.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MeetingDetlDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 785687176137201974L;

	private Integer institutionId;

	private Integer teacherId;

	private Integer createdById;

	@JsonFormat(pattern = "DD/MM/YYYY")
	private Date startDate;

	@JsonFormat(pattern = "DD/MM/YYYY")
	private Date endDate;

	@JsonFormat(pattern = "DD/MM/YYYY")
	private String startTime;

	@JsonFormat(pattern = "DD/MM/YYYY")
	private String endTime;

	private String location;

	private String subject;

	private String description;

	private String meetingStatus;

	private String lastUpdateBy;

	private DateTime lastUpdateTimestamp;

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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
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

	public String getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(String meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public DateTime getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(DateTime lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public List<NotificationTrackingDetailsDto> getNotificationDetails() {
		return notificationDetails;
	}

	public void setNotificationDetails(List<NotificationTrackingDetailsDto> notificationDetails) {
		this.notificationDetails = notificationDetails;
	}

}
