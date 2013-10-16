package com.prodyna.academy.geecon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Location extends BaseEntity {

	@Column(length = 2)
	private String country;

	@Column(length = 64)
	private String city;

}
