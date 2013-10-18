package com.prodyna.academy.geecon;

import java.util.Calendar;

public class NewAttendee {

	private String conference;

	private Calendar dateFrom;

	private Calendar dateTill;

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

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public String getMail() {
	// return mail;
	// }
	//
	// public void setMail(String mail) {
	// this.mail = mail;
	// }

}
