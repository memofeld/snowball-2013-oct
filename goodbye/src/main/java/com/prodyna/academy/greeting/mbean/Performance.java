package com.prodyna.academy.greeting.mbean;

import java.util.ArrayList;
import java.util.List;

public class Performance implements PerformanceMBean {

	private List<String> report = new ArrayList<>();

	@Override
	public void report(String service, String method, long time) {
		report.add(service + "." + method + ": " + time);

	}

	@Override
	public void reset() {
		report.clear();
	}

	@Override
	public List<String> listAvg() {
		return report;
	}

}
