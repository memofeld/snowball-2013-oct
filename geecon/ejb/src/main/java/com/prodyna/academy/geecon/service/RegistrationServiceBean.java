package com.prodyna.academy.geecon.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RegistrationServiceBean {

	public void register(long attendeeId, long talkId) {
		// TODO add registration
	}

}
