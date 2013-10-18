package com.prodyna.academy.geecon;

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
	private final Conference newConference = new Conference();

	@Inject
	ConferenceServiceBean conferenceService;

	@Inject
	private Logger logger;

	public void register() {
		logger.info("Registered successful: " + newConference.getName());
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered " + newConference.getName() + "!",
						"Registration successful"));
		conferenceService.createConferece(newConference);
	}
}
