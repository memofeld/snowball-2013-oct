package com.prodyna.academy.greeting;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GuestbookServiceTest extends AbstractTest {

	@Inject
	GuestbookServiceBean bean;

	@Test
	public void test() throws Exception {
		bean.createEntry("Jürgen", "Hallo World!");
	}

}
