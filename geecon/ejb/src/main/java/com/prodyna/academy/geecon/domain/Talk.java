package com.prodyna.academy.geecon.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Talk extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(length = 128)
	private String title;

	@Column(length = 1000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datetimeFrom;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datetimeTill;

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

}
