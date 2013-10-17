package com.prodyna.academy.greeting;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

@RunWith(Arquillian.class)
public class GreetingServiceTest extends AbstractTest {

	@Inject
	Logger logger;

	@Inject
	GreetingServiceBean greeting;

	@Test
	public void testGreeting() throws Exception {
		Assert.assertNotNull(greeting);
		String s = greeting.hallo("Jürgena");
		Assert.assertEquals("Hallo Jürgen!", s);
		logger.info(s);
	}

}
