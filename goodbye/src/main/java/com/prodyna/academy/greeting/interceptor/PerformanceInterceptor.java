package com.prodyna.academy.greeting.interceptor;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.management.MBeanServer;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;

import org.slf4j.Logger;

import com.prodyna.academy.greeting.mbean.PerformanceMBean;

@Monitored
@Interceptor
public class PerformanceInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	Logger logger;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		long l0 = System.currentTimeMillis();
		Object result = ic.proceed();
		long time = System.currentTimeMillis() - l0;
		String service = ic.getTarget().getClass().getName();
		String method = ic.getMethod().getName();
		logger.info(service + "." + method + ": " + time + "ms");
		try {
			MBeanServer mbeanServer = java.lang.management.ManagementFactory.getPlatformMBeanServer();
			ObjectName objectName = new ObjectName("com.prodyna:service=PerformanceMBean");
			PerformanceMBean mbeanProxy = (PerformanceMBean) MBeanServerInvocationHandler.newProxyInstance(mbeanServer,
					objectName, PerformanceMBean.class, false);
			mbeanProxy.report(service, method, time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
