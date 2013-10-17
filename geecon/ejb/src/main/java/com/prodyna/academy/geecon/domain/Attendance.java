package com.prodyna.academy.geecon.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attendance extends BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredTimestamp;

	@ManyToOne
	@JoinColumn(name = "talk_id")
	private Talk talk;

	@ManyToOne
	@JoinColumn(name = "attendee_id")
	private Attendee attendee;

	public Date getRegisteredTimestamp() {
		return registeredTimestamp;
	}

	public void setRegisteredTimestamp(Date registeredTimestamp) {
		this.registeredTimestamp = registeredTimestamp;
	}

	public Talk getTalk() {
		return talk;
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

}
