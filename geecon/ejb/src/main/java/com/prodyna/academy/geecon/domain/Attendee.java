package com.prodyna.academy.geecon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Attendee extends BaseEntity {

	@Column(length = 64)
	private String firstname;

	@Column(length = 64)
	private String lastname;

}
