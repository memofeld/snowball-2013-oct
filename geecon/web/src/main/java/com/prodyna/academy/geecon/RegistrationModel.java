package com.prodyna.academy.geecon;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;

@Model
public class RegistrationModel {

	@Inject
	private FacesContext facesContext;

	@Produces
	@Named
	private NewAttendee newAttendee;

	@PostConstruct
	public void initNewAttendee() {
		newAttendee = new NewAttendee();
	}

	@Inject
	private Logger logger;

	@Inject
	ConferenceServiceBean conferenceService;

	public void register() {
		logger.info("Registered successful: " + newAttendee.getConference() + ": " + newAttendee.getMail());
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered " + newAttendee.getMail() + "!",
						"Registration successful"));
		Conference c = new Conference();
		c.setName(newAttendee.getConference());
		c.setDateFrom(null);
		c.setDateTill(null);

		Conference conference = conferenceService.createConference(c);
		initNewAttendee();
	}
}
