package com.prodyna.academy.geecon.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attendance extends BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredTimestamp;

	@ManyToOne(cascade = CascadeType.ALL)
	Attendee attendee;

}
