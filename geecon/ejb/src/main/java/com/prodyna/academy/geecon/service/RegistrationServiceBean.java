package com.prodyna.academy.geecon.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prodyna.academy.geecon.domain.Attendance;
import com.prodyna.academy.geecon.domain.Attendee;
import com.prodyna.academy.geecon.domain.Talk;

@Stateless
public class RegistrationServiceBean {

	@Inject
	EntityManager em;

	public void register(long attendeeId, long talkId) {

		Attendance attendance = new Attendance();

		Talk talk = em.find(Talk.class, attendeeId);
		Attendee attendee = em.find(Attendee.class, attendeeId);

		attendance.setAttendee(attendee);
		attendance.setTalk(talk);

		em.persist(attendance);

	}

	// public List<Attendance> getAttendee(){
	//
	// return em.createQuery("from Attendance a left join fetch a.talk ").getResultList();
	// }

}
