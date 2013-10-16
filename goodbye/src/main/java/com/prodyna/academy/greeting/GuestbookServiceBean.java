package com.prodyna.academy.greeting;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;

import com.prodyna.academy.greeting.domain.GuestbookEntry;
import com.prodyna.academy.greeting.interceptor.Monitored;

@Stateless
@Monitored
public class GuestbookServiceBean {

	@Inject
	private EntityManager em;

	@Inject
	private Logger logger;

	public void createEntry(String name, String message) {
		GuestbookEntry entry = new GuestbookEntry();
		entry.setDateOn(new Date());
		entry.setName(name);
		entry.setMessage(message);
		logger.info("Added a new message from: " + name);
		em.persist(entry);
	}

	public List<GuestbookEntry> getEntries() {
		TypedQuery<GuestbookEntry> query = em.createQuery("", GuestbookEntry.class);
		return query.getResultList();
	}

}
