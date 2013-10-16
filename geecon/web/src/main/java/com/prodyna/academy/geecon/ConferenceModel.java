package com.prodyna.academy.geecon;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;

@Model
public class ConferenceModel {

	@Inject
	ConferenceServiceBean conferenceService;

	public List<Conference> getConferenceList() {
		return conferenceService.getConferenceList();
	}

}
