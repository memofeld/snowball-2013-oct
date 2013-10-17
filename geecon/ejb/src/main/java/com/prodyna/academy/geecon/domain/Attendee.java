package com.prodyna.academy.geecon.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Attendee extends BaseEntity {

	@Column(length = 64)
	private String firstname;

	@Column(length = 64)
	private String lastname;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Attendance> attendances;
}
