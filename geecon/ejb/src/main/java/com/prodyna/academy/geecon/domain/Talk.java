package com.prodyna.academy.geecon.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "talk_id")
	// private Room room;
	//
	// @OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "talk_id")
	// private List<Speaker> speakers;
	//
	// @OneToMany(cascade = CascadeType.ALL)
	// private List<Attendance> attendances;

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

	// public Room getRoom() {
	// return room;
	// }
	//
	// public void setRoom(Room room) {
	// this.room = room;
	// }
	//
	// public List<Speaker> getSpeakers() {
	// return speakers;
	// }
	//
	// public void setSpeakers(List<Speaker> speakers) {
	// this.speakers = speakers;
	// }
	//
	// public List<Attendance> getAttendances() {
	// return attendances;
	// }
	//
	// public void setAttendances(List<Attendance> attendances) {
	// this.attendances = attendances;
	// }
}
