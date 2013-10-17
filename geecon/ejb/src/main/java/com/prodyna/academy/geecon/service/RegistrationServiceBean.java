package com.prodyna.academy.geecon.service;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prodyna.academy.geecon.domain.Attendance;
import com.prodyna.academy.geecon.domain.Attendee;
import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.domain.Talk;

@Stateless
public class RegistrationServiceBean {

	@Inject
	private EntityManager em;

	public void register(long attendeeId, long talkId) {
		// TODO add registration
	}

	public Attendance register(Attendee att, Talk talk) {
		Attendance attendance = new Attendance();
		attendance.setAttendee(att);
		attendance.setTalk(talk);
		attendance.setRegisteredTimestamp(new Date(System.currentTimeMillis()));
		em.persist(attendance);
		return attendance;
	}

	public Attendee createAttendee(Conference conference, String firstName, String lastName) {
		Attendee att = new Attendee();
		att.setConference(conference);
		att.setFirstname(firstName);
		att.setLastname(lastName);
		em.persist(att);
		return att;
	}

}
