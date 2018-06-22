package com.bnl.creamson.ptm.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bnl.creamson.ptm.entity.MeetingDtl;

@Repository
public interface MeetingJpaRepository extends CrudRepository<MeetingDtl, Long>{

	public MeetingDtl findByNotificationId(String notificationId);
	
	
}
