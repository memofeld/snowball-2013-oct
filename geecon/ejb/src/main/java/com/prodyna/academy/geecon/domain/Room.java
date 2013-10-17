package com.prodyna.academy.geecon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room extends BaseEntity {

	@Column(length = 64)
	private String name;

	@Column
	private int numberOfSeats;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

}
