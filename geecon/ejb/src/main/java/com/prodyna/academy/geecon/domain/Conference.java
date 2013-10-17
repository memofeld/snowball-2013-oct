package com.prodyna.academy.geecon.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Conference extends BaseEntity {

	@Column(length = 64)
	private String name;

	@Temporal(TemporalType.DATE)
	private Calendar dateFrom;

	@Temporal(TemporalType.DATE)
	private Calendar dateTill;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Talk> talks = new ArrayList<Talk>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Attendee> attendess = new ArrayList<Attendee>();

	@OneToOne(cascade = CascadeType.REFRESH)
	private Location location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Calendar getDateTill() {
		return dateTill;
	}

	public void setDateTill(Calendar dateTill) {
		this.dateTill = dateTill;
	}

	public void setTalks(ArrayList<Talk> talks) {
		this.talks = talks;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}

	public List<Attendee> getAttendess() {
		return attendess;
	}

	public void setAttendess(List<Attendee> attendess) {
		this.attendess = attendess;
	}

	public void setAttendess(ArrayList<Attendee> attendess) {
		this.attendess = attendess;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
