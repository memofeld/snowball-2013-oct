package com.prodyna.academy.geecon;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import com.prodyna.academy.geecon.domain.Attendance;
import com.prodyna.academy.geecon.domain.Attendee;
import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.domain.Talk;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;
import com.prodyna.academy.geecon.service.RegistrationServiceBean;
import com.prodyna.academy.geecon.util.CalendarUtil;

@RunWith(Arquillian.class)
public class ConferenceServiceTest extends AbstractTest {

	@Inject
	private ConferenceServiceBean conferenceService;

	@Inject
	private RegistrationServiceBean regservice;

	@Inject
	Logger logger;

	//
	// @Test
	// public void test() throws Exception {
	// List<Conference> conferenceList = conferenceService.getConferenceList();
	// boolean found = false;
	// for (Conference conference : conferenceList) {
	// if ("JEEcon".equals(conference.getName()))
	// found = true;
	// }
	// Assert.assertTrue(found);
	// }

	@Test
	public void testWriting() throws Exception {
		Conference firtConf = conferenceService.createConferece("JavaEEConference",
				CalendarUtil.getCalendar(2013, 1, 1), CalendarUtil.getCalendar(2013, 1, 4));
		Talk firstTalk = conferenceService.createTalk(firtConf, "JavaEEBasic", "basic intro",
				CalendarUtil.getCalendar(2013, 1, 1), CalendarUtil.getCalendar(2013, 1, 2));
		Talk secondTalk = conferenceService.createTalk(firtConf, "JavaEEPractise", "some exercises",
				CalendarUtil.getCalendar(2013, 1, 3), CalendarUtil.getCalendar(2013, 1, 4));

		Conference secondConf = conferenceService.createConferece("JavaSEConference",
				CalendarUtil.getCalendar(2013, 1, 5), CalendarUtil.getCalendar(2013, 1, 8));
		Talk thirdTalk = conferenceService.createTalk(secondConf, "JavaEEBasic", "basic intro",
				CalendarUtil.getCalendar(2013, 5, 1), CalendarUtil.getCalendar(2013, 1, 6));
		Talk forthTalk = conferenceService.createTalk(secondConf, "JavaEEPractise", "some exercises",
				CalendarUtil.getCalendar(2013, 1, 7), CalendarUtil.getCalendar(2013, 1, 8));

		Attendee firstAttendee = regservice.createAttendee(firtConf, "Danijel", "gornjakovic");

		Attendance attendance = regservice.register(firstAttendee, firstTalk);

		Assert.assertNotNull(firstAttendee.getId());
		logger.info("Reached the end of a test");
	}

	@Test
	public void testReading() throws Exception {
		Assert.assertTrue(conferenceService.getAllConferences().size() > 0);

	}
}
