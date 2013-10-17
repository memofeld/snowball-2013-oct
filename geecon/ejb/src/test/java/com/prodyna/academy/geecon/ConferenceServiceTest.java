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

@RunWith(Arquillian.class)
public class ConferenceServiceTest extends AbstractTest {

	@Inject
	private ConferenceServiceBean conferenceService;
	@Inject
	Logger logerr;

	@Test
	public void test() throws Exception {
		List<Conference> conferenceList = conferenceService.getConferenceList();
		boolean found = false;
		for (Conference conference : conferenceList) {
			if ("JEEcon".equals(conference.getName()))
				found = true;
		}

		// Assert.assertTrue(found);

		found = false;
		// add talks
		for (Conference conference : conferenceList) {
			conferenceService.addTalks(conference);
		}

		// check
		for (Conference conference : conferenceList) {
			for (Talk t : conference.getTalks())
				if ("talk".equals(t.getDescription()))
					found = true;
		}
		Assert.assertTrue(found);
	}
}
