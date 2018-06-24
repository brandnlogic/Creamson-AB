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
		
		List<Predicate> andClause = new ArrayList<Predicate>();
		List<Predicate> orClause = new ArrayList<Predicate>();
		
		
			orClause.add(criteriaBuilder.and(criteriaBuilder.lessThan(from.get("startDate"), meetingDetl.getStartDate()),
											 criteriaBuilder.greaterThan(from.get("endDate"), meetingDetl.getEndDate())));
			
			orClause.add(criteriaBuilder.between(from.get("startDate"), meetingDetl.getStartDate(), meetingDetl.getEndDate()));
			orClause.add(criteriaBuilder.between(from.get("endDate"), meetingDetl.getStartDate(), meetingDetl.getEndDate()));
			

			andClause.add(criteriaBuilder.or(orClause.toArray(new Predicate[orClause.size()])));
			
		if(meetingDetl.getStartDate() != null){
			andClause.add(criteriaBuilder.equal(from.get("teacherId"), meetingDetl.getTeacherId()));
		}
		if(meetingDetl.getStartDate() != null){
			andClause.add(criteriaBuilder.equal(from.get("institutionId"), meetingDetl.getInstitutionId()));
		}
		
		andClause.add(criteriaBuilder.equal(from.get("meetingStatus"), MeetingStatus.Active));
		
		
		return entitymanager.createQuery(createQuery.where(andClause.toArray(new Predicate[andClause.size()]))).getResultList();
	}

}
