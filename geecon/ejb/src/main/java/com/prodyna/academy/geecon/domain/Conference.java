package com.prodyna.academy.geecon.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Conference extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(length = 64)
	private String name;

	@Temporal(TemporalType.DATE)
	private Calendar dateFrom;

	@Temporal(TemporalType.DATE)
	private Calendar dateTill;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "talk_id")
	private List<Talk> talkList = new ArrayList<Talk>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Calendar getDateTill() {
		return dateTill;
	}

	public void setDateTill(Calendar dateTill) {
		this.dateTill = dateTill;
	}

	public List<Talk> getTalkList() {
		return talkList;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
