package com.bnl.creamson.ptm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bnl.creamson.ptm.application.ApplicationMessage;
import com.bnl.creamson.ptm.dto.MeetingDetlDto;
import com.bnl.creamson.ptm.entity.MeetingDtl;
import com.bnl.creamson.ptm.repository.CustomRepositoryModel;
import com.bnl.creamson.ptm.repository.jpa.MeetingJpaRepository;
import com.bnl.creamson.ptm.util.ObjectMapperUtils;

/**
 * 
 * @author liveyoung
 *
 */
@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private CustomRepositoryModel customRepositoryModel;
	
	@Autowired
	private MeetingJpaRepository meetingJpaRepository; 
	
	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public MeetingDetlDto saveMeetingDetails(final MeetingDetlDto meetingDetlDto, final List<ApplicationMessage> message) {

		MeetingDetlDto newlyCreatedEntity= new MeetingDetlDto();
		if (meetingDetlDto.isAcceptConflict()) {
			MeetingDtl meetingEntity = ObjectMapperUtils.map(meetingDetlDto, MeetingDtl.class);
			newlyCreatedEntity = ObjectMapperUtils.map(meetingJpaRepository.save(meetingEntity), MeetingDetlDto.class);
		} else {
			final MeetingDetlDto searchMeeting = new MeetingDetlDto();
			searchMeeting.setInstitutionId(meetingDetlDto.getInstitutionId());
			searchMeeting.setTeacherId(meetingDetlDto.getTeacherId());
			searchMeeting.setStartDate(meetingDetlDto.getStartDate());
			searchMeeting.setEndDate(meetingDetlDto.getEndDate());
			searchMeeting.setStartTime(meetingDetlDto.getStartTime());
			searchMeeting.setEndTime(meetingDetlDto.getEndTime());
			List<MeetingDtl> searchMeetingDetails = customRepositoryModel.searchMeetingDetails(meetingDetlDto);
			if (searchMeetingDetails.size() > 0) {
				message.add(ApplicationMessage.METTING_CONFLICT_WARNING_MESSAGE);
			} else{
				MeetingDtl meetingEntity = ObjectMapperUtils.map(meetingDetlDto, MeetingDtl.class);
				meetingJpaRepository.save(meetingEntity);
				newlyCreatedEntity = ObjectMapperUtils.map(meetingJpaRepository.save(meetingEntity), MeetingDetlDto.class);
			}
		}
		return newlyCreatedEntity;
	}

	@Override
	@Transactional(propagation= Propagation.NOT_SUPPORTED)
	public List<MeetingDetlDto> searchMeetingDetails(final MeetingDetlDto meetingDetlDto, final List<ApplicationMessage> message) {
		return ObjectMapperUtils.mapAll(customRepositoryModel.searchMeetingDetails(meetingDetlDto), MeetingDetlDto.class);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public void deleteMeetingDetails(final MeetingDetlDto meetingDetlDto, final List<ApplicationMessage> message) {
		MeetingDtl meetingEntity = meetingJpaRepository.findByNotificationId(meetingDetlDto.getNotificationId());
		meetingJpaRepository.delete(meetingEntity);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public MeetingDetlDto updateMeetingStatus(final MeetingDetlDto meetingDetlDto, final List<ApplicationMessage> message) {
		MeetingDtl meetingEntity = meetingJpaRepository.findByNotificationId(meetingDetlDto.getNotificationId());
		meetingEntity.setMeetingStatus(meetingDetlDto.getMeetingStatus());
		meetingJpaRepository.save(meetingEntity);
		return meetingDetlDto;
	}

}
