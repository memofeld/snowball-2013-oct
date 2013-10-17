package com.prodyna.academy.geecon;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.domain.Talk;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;

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
	public void createConference() {
		Conference conference = new Conference();
		conference.setName("Spring training");
		conference.setDateFrom(Calendar.getInstance());
		conference.setDateTill(Calendar.getInstance());

		List<Talk> talks = new ArrayList<Talk>();
		Talk springTalk = new Talk();
		springTalk.setTitle("Whats new in Spring");
		springTalk.setDescription("Something");
		talks.add(springTalk);

		conference.setTalks(talks);

		conferenceService.createConference(conference);
	}

	@Test
	public void getConferences() {
		List<Conference> conferenes = conferenceService.getAllConferences();
		Assert.assertTrue(conferenes.size() > 0);
	}
}
