package com.prodyna.academy.geecon.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.util.CalendarUtil;

@Stateless
public class ConferenceServiceBean {

	@Inject
	private EntityManager em;

	@Inject
	private Logger logger;

	public Conference createConference(String name, Calendar dateFrom, Calendar dateTill) {

		Conference entry = new Conference();
		entry.setDateFrom(CalendarUtil.getCalendar(2013, 10, 15));
		entry.setName(name);
		entry.setDateTill(CalendarUtil.getCalendar(2013, 10, 17));
		logger.info("Added a new name: " + name);
		em.persist(entry);

		return entry;

	}

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

	public List<Conference> getEntries() {
		TypedQuery<Conference> query = em.createQuery("SELECT C FROM Conference C", Conference.class);
		return query.getResultList();
	}

	public List<Conference> getAllConferences() {
		TypedQuery<Conference> query = em.createQuery("SELECT C FROM Conference C", Conference.class);
		return query.getResultList();
	}

}
