package com.bnl.creamson.ptm.repository;

import java.util.List;

import com.bnl.creamson.ptm.dto.MeetingDetlDto;
import com.bnl.creamson.ptm.entity.MeetingDtl;

public interface CustomRepositoryModel {

	public List<MeetingDtl> searchMeetingDetails(final MeetingDetlDto meetingDetl);
}
