package com.prodyna.academy.greeting.interceptor;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

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
		long dur = System.currentTimeMillis() - l0;
		logger.info(ic.getTarget().getClass().getName() + "." + ic.getMethod().getName() + ": " + dur + "ms");
		return result;

	}
}
