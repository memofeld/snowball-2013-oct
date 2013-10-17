package com.prodyna.academy.geecon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Speaker extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(length = 64)
	private String firstname;

	@Column(length = 64)
	private String lastname;

}
