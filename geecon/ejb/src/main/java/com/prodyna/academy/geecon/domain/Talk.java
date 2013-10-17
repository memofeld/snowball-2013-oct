package com.prodyna.academy.geecon.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Talk extends BaseEntity {

	@Column(length = 128)
	private String title;

	@Column(length = 1000)
	private String description;

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

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datetimeFrom;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datetimeTill;

	@ManyToOne
	@JoinColumn(name = "conference_id")
	private Conference conference;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "talk_id")
	private List<Attendance> attendanceLst;

}
