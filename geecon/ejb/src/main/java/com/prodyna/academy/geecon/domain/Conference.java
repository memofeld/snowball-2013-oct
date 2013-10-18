package com.prodyna.academy.geecon.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.prodyna.academy.geecon.util.CalendarUtil;

@Entity
public class Conference extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4810355566604830181L;

	@Column(length = 64)
	private String name;

	@Temporal(TemporalType.DATE)
	private Calendar dateFrom = CalendarUtil.getCalendarToday();

	@Temporal(TemporalType.DATE)
	private Calendar dateTill = CalendarUtil.getCalendarToday();

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conference_id")
	private List<Attendee> atendeeList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conference_id")
	private List<Talk> talkList;

	@ManyToOne
	@JoinColumn(name = "conference_id")
	private Location location;

}
