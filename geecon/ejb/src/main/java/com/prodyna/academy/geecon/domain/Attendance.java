package com.prodyna.academy.geecon.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attendance extends BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredTimestamp;

	@OneToOne(cascade = CascadeType.REFRESH)
	private Attendee attendee;

	@OneToOne(cascade = CascadeType.REFRESH)
	private Talk talk;

	public Date getRegisteredTimestamp() {
		return registeredTimestamp;
	}

	public void setRegisteredTimestamp(Date registeredTimestamp) {
		this.registeredTimestamp = registeredTimestamp;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	public Talk getTalk() {
		return talk;
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	
	
}
