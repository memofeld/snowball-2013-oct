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

}
