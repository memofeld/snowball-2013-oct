package com.prodyna.academy.geecon.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.util.CalendarUtil;

@Stateless
public class ConferenceServiceBean {

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
