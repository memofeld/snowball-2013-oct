package com.prodyna.academy.geecon.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	// public void setTalk()
	// {
	// }

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conference_id")
	private List<Talk> talksList;

}
