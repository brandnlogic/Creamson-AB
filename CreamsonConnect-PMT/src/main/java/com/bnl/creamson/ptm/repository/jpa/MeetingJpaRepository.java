package com.bnl.creamson.ptm.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnl.creamson.ptm.entity.MeetingDtl;

@Repository
public interface MeetingJpaRepository extends JpaRepository<MeetingDtl, Long>{

	public MeetingDtl findByNotificationId(String notificationId);
	
	
}
