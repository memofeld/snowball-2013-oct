package com.prodyna.academy.geecon.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.domain.Talk;
import com.prodyna.academy.geecon.util.CalendarUtil;

@Stateless
public class ConferenceServiceBean {

	@Inject
	private EntityManager em;

	public List<Conference> getConferenceList() {
		// TODO read from database
		// please delete dummy code below
		List<Conference> out = new ArrayList<Conference>();
		{
			Conference c = new Conference();
			c.setName("JEEcon");
			c.setDateFrom(CalendarUtil.getCalendar(2013, 10, 15));
			c.setDateTill(CalendarUtil.getCalendar(2013, 10, 17));
			out.add(c);
		}
		{
			Conference c = new Conference();
			c.setName("JavaCON");
			c.setDateFrom(CalendarUtil.getCalendar(2013, 10, 22));
			c.setDateTill(CalendarUtil.getCalendar(2013, 10, 23));
			out.add(c);
		}
		return out;

	}

	public Conference createConferece(String name, Calendar calendarFrom, Calendar calendarTill) {
		Conference conference = new Conference();
		conference.setName(name);
		conference.setDateFrom(calendarFrom);
		conference.setDateTill(calendarTill);
		em.persist(conference);
		return conference;
	}

	public Talk createTalk(Conference conference, String title, String description, Calendar calendarFrom,
			Calendar calendarTill) {
		Talk talk = new Talk();
		talk.setTitle(title);
		talk.setDescription(description);
		talk.setDatetimeFrom(calendarFrom);
		talk.setDatetimeTill(calendarTill);
		talk.setConference(conference);
		em.persist(talk);
		return talk;
	}

	public List<Conference> getAllConferences() {
		return em.createQuery("select c from Conference c", Conference.class).getResultList();
	}

	public List<Conference> getConferenceByTalk(Long talkId) {
		return em.createQuery("select c from Conference c where c.talk_id = :talk", Conference.class)
				.setParameter("talk", talkId).getResultList();
	}

	public Conference doFancyStuff() throws Exception {
		return null;
	}

	public void createConferece(Conference newConference) {
		em.persist(newConference);

	}
}
