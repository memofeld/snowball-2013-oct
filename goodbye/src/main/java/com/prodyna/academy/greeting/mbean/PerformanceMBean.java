package com.prodyna.academy.greeting.mbean;

import java.util.List;

public interface PerformanceMBean {

	void report(String service, String method, long time);

	void reset();

	List<String> listAvg();

}
