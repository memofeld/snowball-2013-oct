package com.prodyna.academy.geecon.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.util.CalendarUtil;

@Stateless
public class ConferenceServiceBean {

	@Inject
	private EntityManager em;

	public void createConference(String name, Date dateFrom, Date dateTill) {

		Conference c = new Conference();
		c.setName(name);
		c.setDateFrom(CalendarUtil.getCalendar(2013, 10, 15));
		c.setDateTill(CalendarUtil.getCalendar(2013, 10, 17));
		em.persist(c);
	}

	public List<Conference> getConferences() {

		TypedQuery<Conference> query = em.createQuery("SELECT C from Conference C", Conference.class);
		return query.getResultList();
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

}
