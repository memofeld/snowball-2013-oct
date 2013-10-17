package com.prodyna.academy.geecon.service;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class MyCheckedException extends Exception {

	public MyCheckedException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
