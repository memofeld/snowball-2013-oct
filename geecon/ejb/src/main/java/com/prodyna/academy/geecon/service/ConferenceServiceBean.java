package com.prodyna.academy.geecon.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.prodyna.academy.geecon.domain.Conference;

@Stateless
@WebService
@LocalBean
public class ConferenceServiceBean {

	@Inject
	private EntityManager em;

	@Inject
	Logger logger;

	public Conference createConference(Conference conference) {
		em.persist(conference);
		return conference;
	}

	public List<Conference> getAllConferences() {
		List<Conference> conferences = em.createQuery("from Conference c", Conference.class).getResultList();
		return conferences;
	}

	public Conference getById(Long id) {
		return em.find(Conference.class, id);
	}

	public Conference update(Conference conference) {
		conference = em.merge(conference);
		return conference;
	}

	public Conference update1(Conference conference) throws Exception {
		conference = em.merge(conference);
		throw new RuntimeException("my runtime exception");
	}

	public Conference update2(Conference conference) throws Exception {
		conference = em.merge(conference);
		throw new MyCheckedException("my checked exception");
	}

}
