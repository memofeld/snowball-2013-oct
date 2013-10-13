package com.prodyna.academy.greeting;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

@RunWith(Arquillian.class)
public class GreetingServiceTest {

	@Deployment
	protected static Archive<?> deployment() {
		return ShrinkWrap.create(WebArchive.class)
				.addPackages(true, "com.prodyna.academy")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	Logger logger;

	@Inject
	GreetingServiceBean greeting;

	@Test
	public void testGreeting() throws Exception {
		Assert.assertNotNull(greeting);
		String s = greeting.hallo("Jürgen");
		Assert.assertTrue(s.contains("Hallo"));
		logger.info(s);
	}

}
