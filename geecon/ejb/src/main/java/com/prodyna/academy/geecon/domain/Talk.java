package com.prodyna.academy.geecon.domain;

import java.util.Date;

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

	@Temporal(TemporalType.DATE)
	private Date dateOn;

	@Temporal(TemporalType.TIME)
	private Date timeFrom;

	@Temporal(TemporalType.TIME)
	private Date timeTill;

}
