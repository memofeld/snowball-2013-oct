package com.prodyna.academy.geecon.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attendance extends BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredTimestamp;

}
