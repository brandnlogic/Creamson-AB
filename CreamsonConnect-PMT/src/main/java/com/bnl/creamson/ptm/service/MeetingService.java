package com.bnl.creamson.ptm.service;

import java.util.List;

import com.bnl.creamson.ptm.application.ApplicationMessage;
import com.bnl.creamson.ptm.dto.MeetingDetlDto;

public interface MeetingService {

	/**
	 * Save meeting details in MEETING_DTLS and NOTIFICATION_TRACKING_DTLS tables.
	 * It will check database schedule timing on the basis of following criteria
	 * 
	 *  INSTITUTION_ID, TEACHER_ID, START_DATE, END_DATE, START_TIME, END_TIME
	 *  If 
	 *  	there exist a meeting then show a conflict 
	 *  else 
	 *  	persist record.
	 *  
	 *  on the basis of flag acceptConflict it will persist conflict meeting
	 *  
	 * @param meetingDetlDto
	 * @return
	 */
	public MeetingDetlDto saveMeetingDetails(MeetingDetlDto meetingDetlDto, List<ApplicationMessage> message); 
	
	/**
	 * Base on criteria in MeetingDetl it will retrieve meeting details list 
	 * @param meetingDetlDto
	 * @return
	 */
	public List<MeetingDetlDto> searchMeetingDetails(MeetingDetlDto meetingDetlDto, List<ApplicationMessage> message);
	
	/**
	 * Rules for deleting user 
	 * 	1. Meeting can only be deleted by created by user.
	 * 	2. Meeting cannot be delete once it get started.
	 *  3. It will delete the record from database
	 * @param meetingDetlDto
	 * @return
	 */
	public void deleteMeetingDetails(MeetingDetlDto meetingDetlDto, List<ApplicationMessage> message);
	
	/**
	 *  To update the status of meeting 
	 * 	
	 * @param meetingDetlDto
	 * @return
	 */
	public MeetingDetlDto updateMeetingStatus(MeetingDetlDto meetingDetlDto, List<ApplicationMessage> message);
	
}
