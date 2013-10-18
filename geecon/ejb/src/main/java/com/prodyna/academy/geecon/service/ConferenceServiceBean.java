package com.prodyna.academy.geecon.service;

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
	EntityManager em;

	public List<Conference> getConferenceList() {

		Conference c = new Conference();
		c.setName("JEEcon");
		c.setDateFrom(CalendarUtil.getCalendar(2013, 10, 15));
		c.setDateTill(CalendarUtil.getCalendar(2013, 10, 17));

		Conference c1 = new Conference();
		c1.setName("JavaCON");
		c1.setDateFrom(CalendarUtil.getCalendar(2013, 10, 22));
		c1.setDateTill(CalendarUtil.getCalendar(2013, 10, 23));

		em.persist(c);
		em.persist(c1);

		List<Conference> out = em.createQuery("from Conference", Conference.class).getResultList();
		return out;

	}

	public boolean addTalks(Conference c) {

		c = em.merge(c);

		Talk talk = new Talk();
		talk.setDescription("talk");
		talk.setTitle("talk title");

		c.getTalks().add(talk);

		return true;
	}

	public List<Conference> getConferenceListWithTalk() {

		return em.createQuery("from Conference c left join fetch c.talks ", Conference.class).getResultList();

	}
}
