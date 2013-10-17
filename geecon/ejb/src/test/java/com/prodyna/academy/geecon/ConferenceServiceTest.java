package com.prodyna.academy.geecon;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.domain.Talk;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;
import com.prodyna.academy.geecon.util.CalendarUtil;

@RunWith(Arquillian.class)
public class ConferenceServiceTest extends AbstractTest {

	@Inject
	private ConferenceServiceBean conferenceService;

	@Inject
	Logger logger;

	@Test
	public void testCreate() throws Exception {
		create("JEEcon");
		create("JavaCON");
	}

	private void create(String title) throws Exception {
		Conference c = new Conference();
		c.setName(title);
		c.setDateFrom(CalendarUtil.getCalendar(2013, 10, 15));
		c.setDateTill(CalendarUtil.getCalendar(2013, 10, 17));
		{
			Talk t = new Talk();
			t.setTitle("JPA");
			t.setDescription("...");
			t.setDatetimeFrom(CalendarUtil.getCalendar(2013, 10, 15, 14, 0));
			t.setDatetimeTill(CalendarUtil.getCalendar(2013, 10, 15, 15, 0));
			c.getTalkList().add(t);
		}
		{
			Talk t = new Talk();
			t.setTitle("Maven");
			t.setDescription("...");
			t.setDatetimeFrom(CalendarUtil.getCalendar(2013, 10, 15, 15, 30));
			t.setDatetimeTill(CalendarUtil.getCalendar(2013, 10, 15, 16, 30));
			c.getTalkList().add(t);
		}
		Conference conference = conferenceService.createConference(c);
		Assert.assertNotNull(conference);
		Assert.assertNotNull(conference.getId());
	}

	@Test
	public void testRead() throws Exception {
		List<Conference> allConferences = conferenceService.getAllConferences();
		for (Conference conference : allConferences) {
			logger.info(conference.getName());
		}
	}

}
