package com.prodyna.academy.geecon;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;
import com.prodyna.academy.geecon.util.CalendarUtil;

@RunWith(Arquillian.class)
public class ConferenceServiceTest extends AbstractTest {

	@Inject
	private ConferenceServiceBean conferenceService;

	@Test
	public void test() throws Exception {
		List<Conference> conferenceList = conferenceService.getConferenceList();
		boolean found = false;
		for (Conference conference : conferenceList) {
			if ("JEEcon".equals(conference.getName()))
				found = true;
		}
		Assert.assertTrue(found);
	}

	@Test
	public void test1() throws Exception {
		conferenceService.createConference("bilo sta", CalendarUtil.getCalendar(2013, 10, 15),
				CalendarUtil.getCalendar(2013, 10, 17));

	}

	@Test
	public void test2() throws Exception {

		// conferenceService.getEntries();
		List<Conference> conf = conferenceService.getEntries();
	}
}
