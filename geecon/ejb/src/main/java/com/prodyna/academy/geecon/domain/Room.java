package com.prodyna.academy.geecon.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Room extends BaseEntity {

	@Column(length = 64)
	private String name;

	@Column(length = 16)
	private String roomNumber;

	@Temporal(TemporalType.DATE)
	private Date dateOn;

	@Column
	private int numberOfSeats;

}
