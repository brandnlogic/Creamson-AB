package com.bnl.creamson.ptm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bnl.creamson.ptm.dto.MeetingDetlDto;
import com.bnl.creamson.ptm.entity.MeetingDtl;
import com.bnl.creamson.ptm.enums.MeetingStatus;

@Repository
public class CustomRepositoryModelImpl implements CustomRepositoryModel {

	@PersistenceContext(unitName = "cremsonEntityManager")
	private EntityManager entitymanager;
	
	@Override
	public List<MeetingDtl> searchMeetingDetails(MeetingDetlDto meetingDetl) {
		final CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		
		final CriteriaQuery<MeetingDtl> createQuery = criteriaBuilder.createQuery(MeetingDtl.class);
		final Root<MeetingDtl> from = createQuery.from(MeetingDtl.class);
		
		List<Predicate> whereClause = new ArrayList<Predicate>();
		
		if(meetingDetl.getStartDate() != null){
			whereClause.add(criteriaBuilder.greaterThanOrEqualTo(from.get("startDate"), meetingDetl.getStartDate()));
		}
		
		if(meetingDetl.getStartDate() != null){
			whereClause.add(criteriaBuilder.lessThanOrEqualTo(from.get("endDate"), meetingDetl.getEndDate()));
		}
		
		if(meetingDetl.getStartDate() != null){
			whereClause.add(criteriaBuilder.greaterThanOrEqualTo(from.get("startTime"), meetingDetl.getStartTime()));
		}
		if(meetingDetl.getStartDate() != null){
			whereClause.add(criteriaBuilder.lessThanOrEqualTo(from.get("endTime"), meetingDetl.getEndTime()));
		}
		
		if(meetingDetl.getStartDate() != null){
			whereClause.add(criteriaBuilder.equal(from.get("teacherId"), meetingDetl.getTeacherId()));
		}
		if(meetingDetl.getStartDate() != null){
			whereClause.add(criteriaBuilder.equal(from.get("institutionId"), meetingDetl.getInstitutionId()));
		}
		
		whereClause.add(criteriaBuilder.equal(from.get("meetingStatus"), MeetingStatus.Active));
		
		return entitymanager.createQuery(createQuery.where(whereClause.toArray(new Predicate[whereClause.size()]))).getResultList();
	}

}
