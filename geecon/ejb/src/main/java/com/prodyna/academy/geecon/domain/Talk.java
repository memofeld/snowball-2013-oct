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
public class Talk extends BaseEntity {

	@Column(length = 128)
	private String title;

	@Column(length = 1000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datetimeFrom;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datetimeTill;

	@OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = true)
	private List<Speaker> speakers = new ArrayList<Speaker>();

	@OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
	private Room room;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDatetimeFrom() {
		return datetimeFrom;
	}

	public void setDatetimeFrom(Calendar datetimeFrom) {
		this.datetimeFrom = datetimeFrom;
	}

	public Calendar getDatetimeTill() {
		return datetimeTill;
	}

	public void setDatetimeTill(Calendar datetimeTill) {
		this.datetimeTill = datetimeTill;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
