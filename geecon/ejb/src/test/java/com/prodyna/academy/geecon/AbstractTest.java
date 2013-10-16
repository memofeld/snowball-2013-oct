package com.prodyna.academy.geecon;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class AbstractTest {

	@Deployment
	protected static Archive<?> deployment() {
		return ShrinkWrap.create(WebArchive.class).addPackages(true, "com.prodyna.academy")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource("META-INF/beans.xml").addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}
}
