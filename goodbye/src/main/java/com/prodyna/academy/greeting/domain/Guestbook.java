package com.prodyna.academy.greeting.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Guestbook {

	@Id
	Long id;

	String message;

}
