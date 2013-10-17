package com.prodyna.academy.geecon.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import com.prodyna.academy.geecon.domain.Conference;
import com.prodyna.academy.geecon.service.ConferenceServiceBean;

@Path("/conference")
public class ConferenceRestResource {

	@Inject
	private ConferenceServiceBean conferenceService;

	@Inject
	Logger logger;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Conference getConference(@PathParam("id") Long id) {
		return conferenceService.getById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Conference> getConferences() {
		return conferenceService.getAllConferences();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public void save(Conference c) {
		conferenceService.createConference(c);
	}

}
