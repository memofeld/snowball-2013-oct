package com.prodyna.academy.geecon.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prodyna.academy.geecon.domain.Conference;

@Stateless
public class ConferenceServiceBean {

	@Inject
	private EntityManager em;

	public void createConference(Conference conference) {
		em.persist(conference);
	}

	public List<Conference> getAllConferences() {
		List<Conference> conferences = em.createQuery("from Conference c", Conference.class).getResultList();
		return conferences;
	}

	public Conference doFancyStuff() throws Exception {
		return null;
	}

}
