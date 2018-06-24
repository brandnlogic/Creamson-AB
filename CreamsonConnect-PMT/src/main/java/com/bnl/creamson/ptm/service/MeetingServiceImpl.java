package com.bnl.creamson.ptm.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bnl.creamson.ptm.application.ApplicationMessage;
import com.bnl.creamson.ptm.dto.MeetingDetlDto;
import com.bnl.creamson.ptm.entity.MeetingDtl;
import com.bnl.creamson.ptm.enums.NotificationStatus;
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
			meetingEntity.setCreatedTimestamp(LocalDateTime.now());
			meetingEntity.setLastUpdateTimestamp(LocalDateTime.now());
			meetingEntity.getNotificationDetails().stream().filter(Objects::nonNull).
							forEach(e->{e.setNotificationStatus(NotificationStatus.NotDelivered);
							e.setLastUpdateTimestamp(LocalDateTime.now());
							e.setLastUpdateId(meetingEntity.getLastUpdateId());
							e.setMeetingDtl(meetingEntity);});
			newlyCreatedEntity = ObjectMapperUtils.map(meetingJpaRepository.save(meetingEntity), MeetingDetlDto.class);
		} else {
			final MeetingDetlDto searchMeeting = new MeetingDetlDto();
			searchMeeting.setInstitutionId(meetingDetlDto.getInstitutionId());
			searchMeeting.setTeacherId(meetingDetlDto.getTeacherId());
			searchMeeting.setStartDate(meetingDetlDto.getStartDate());
			searchMeeting.setEndDate(meetingDetlDto.getEndDate());
			List<MeetingDtl> searchMeetingDetails = customRepositoryModel.searchMeetingDetails(meetingDetlDto);
			if (searchMeetingDetails.size() > 0) {
				message.add(ApplicationMessage.METTING_CONFLICT_WARNING_MESSAGE);
			} else{
				MeetingDtl meetingEntity = ObjectMapperUtils.map(meetingDetlDto, MeetingDtl.class);
				meetingEntity.setCreatedTimestamp(LocalDateTime.now());
				meetingEntity.setLastUpdateTimestamp(LocalDateTime.now());
				meetingEntity.getNotificationDetails().stream().filter(Objects::nonNull).
											forEach(e->{e.setNotificationStatus(NotificationStatus.NotDelivered);
														e.setLastUpdateTimestamp(LocalDateTime.now());
														e.setLastUpdateId(meetingEntity.getLastUpdateId());
														e.setMeetingDtl(meetingEntity);});
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
