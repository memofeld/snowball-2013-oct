package com.prodyna.academy.geecon;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.prodyna.academy.geecon.service.ConferenceServiceBean;

@Model
public class RegistrationModel {

	@Inject
	private FacesContext facesContext;

	@Produces
	@Named
	private NewAttendee newAttendee;

	@Inject
	private EntityManager em;

	@Inject
	private Logger logger;

	@Inject
	ConferenceServiceBean conferenceService;

	@PostConstruct
	public void initNewAttendee() {

	}

	public void register() {

		conferenceService.createConference(newAttendee.getConference(), newAttendee.getDateFrom(),
				newAttendee.getDateTill());
	}

}
