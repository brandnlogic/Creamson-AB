package com.bnl.creamson.ptm.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DURATION")
	private Time duration;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "END_TIME")
	private Time endTime;

	@Column(name = "INSTITUTION_ID")
	private int institutionId;

	@Column(name = "LAST_UPDATE_ID")
	private String lastUpdateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_TIMESTAMP")
	private Date lastUpdateTimestamp;

	@Column(name = "CREATED_BY_ID")
	private String createdById;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIMESTAMP")
	private Date createdTimestamp;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "MEETING_STATUS")
	@Convert(converter = MeetingStatusEntityDataConverter.class)
	private MeetingStatus meetingStatus;

	@Column(name = "NOTIFICATION_ID")
	private String notificationId;

	@Column(name = "SET_BY_USER_ID")
	private int setByUserId;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "START_TIME")
	private Time startTime;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "TEACHER_ID")
	private int teacherId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="")
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

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Time getDuration() {
		return this.duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public int getInstitutionId() {
		return this.institutionId;
	}

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
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

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
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

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

}