package com.bnl.creamson.ptm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the MEETING_DTLS database table.
 * 
 */
@Entity
@Table(name="MEETING_DTLS")
@NamedQuery(name="MeetingDtl.findAll", query="SELECT m FROM MeetingDtl m")
public class MeetingDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MEETING_ID")
	private int meetingId;

	@Lob
	@Column(name="DESCRIPTION")
	private byte[] description;

	@Column(name="DURATION")
	private Time duration;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="END_TIME")
	private Time endTime;

	@Column(name="INSTITUTION_ID")
	private int institutionId;

	@Column(name="LAST_UPDATE_ID")
	private String lastUpdateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_TIMESTAMP")
	private Date lastUpdateTimestamp;

	@Column(name="LOCATION")
	private String location;

	@Column(name="MEETING_STATUS")
	private int meetingStatus;

	@Column(name="NOTIFICATION_ID")
	private String notificationId;

	@Column(name="SET_BY_USER_ID")
	private int setByUserId;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="START_TIME")
	private Time startTime;

	@Column(name="SUBJECT")
	private String subject;

	@Column(name="TEACHER_ID")
	private int teacherId;

	public MeetingDtl() {
	}

	public int getMeetingId() {
		return this.meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public byte[] getDescription() {
		return this.description;
	}

	public void setDescription(byte[] description) {
		this.description = description;
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

	public int getMeetingStatus() {
		return this.meetingStatus;
	}

	public void setMeetingStatus(int meetingStatus) {
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

}