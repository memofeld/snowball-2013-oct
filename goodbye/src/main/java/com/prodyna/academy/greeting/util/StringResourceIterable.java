package com.prodyna.academy.greeting.util;

import java.util.Iterator;

public class StringResourceIterable implements Iterable<String>, AutoCloseable {

	@Override
	public void close() throws Exception {
		// http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
