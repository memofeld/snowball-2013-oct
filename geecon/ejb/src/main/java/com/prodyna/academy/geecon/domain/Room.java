package com.prodyna.academy.geecon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Room extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(length = 64)
	private String name;

	@Column
	private int numberOfSeats;

}
