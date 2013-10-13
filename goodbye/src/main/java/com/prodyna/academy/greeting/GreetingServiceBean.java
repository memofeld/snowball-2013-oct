package com.prodyna.academy.greeting;

import javax.ejb.Stateless;

@Stateless
public class GreetingServiceBean {

	public String hallo(String name) {
		return "Hallo " + name;
	}

}
