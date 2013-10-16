package com.prodyna.academy.greeting.mbean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.Logger;

@Startup
@Singleton
public class StartupTrigger {

	@Resource
	EJBContext context;

	@Inject
	Logger logger;

	@PostConstruct
	public void start() {
		try {
			MBeanServer mbeanServer = java.lang.management.ManagementFactory.getPlatformMBeanServer();
			ObjectName objectName = new ObjectName("com.prodyna:service=PerformanceMBean");
			if (mbeanServer.isRegistered(objectName)) {
				// mbeanServer.unregisterMBean(objectName);
			} else {
				Performance p = new Performance();
				mbeanServer.registerMBean(p, objectName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
