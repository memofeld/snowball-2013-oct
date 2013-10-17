package com.prodyna.academy.geecon.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;

@Path("/conference")
public class ConferenceRestResource {

	@Inject
	private ConferenceServiceBean conferenceService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Conference getConference(@PathParam("id") Long id) {
		return conferenceService.getById(id);
	}

}
