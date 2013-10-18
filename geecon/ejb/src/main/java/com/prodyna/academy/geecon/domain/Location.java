package com.prodyna.academy.geecon.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Location extends BaseEntity {

	@Column(length = 2)
	private String country;

	@Column(length = 64)
	private String locality;

	@Column(length = 64)
	private String city;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "location_id")
	private List<Room> roomList;

}
