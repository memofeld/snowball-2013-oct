package com.prodyna.academy.geecon;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;
import com.prodyna.academy.geecon.service.MyCheckedException;

@RunWith(Arquillian.class)
public class Update2Test extends AbstractTest {
	@Inject
	private ConferenceServiceBean conferenceService;

	@Inject
	Logger logger;

	@Test(expected = MyCheckedException.class)
	public void testFancyStuff() throws Exception {
		Conference conference = conferenceService.getAllConferences().get(0);
		conference.setName("JEE Reloaded (Test2)");
		conferenceService.update2(conference);
	}

}
