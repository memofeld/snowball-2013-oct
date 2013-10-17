package com.prodyna.academy.geecon;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;

@Model
public class ConferenceModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ConferenceServiceBean conferenceService;

	public List<Conference> getConferenceList() {
		return conferenceService.getAllConferences();
	}

}
