package com.prodyna.academy.geecon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Speaker extends BaseEntity {

	@Column(length = 64)
	private String firstname;

	@Column(length = 64)
	private String lastname;

}
