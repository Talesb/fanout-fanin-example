package com.talesb.example.designpattern;

import java.util.concurrent.atomic.AtomicLong;

public class Consumer {

	private final AtomicLong sumOfSquaredNumbers;

	public Consumer(Long init) {
		sumOfSquaredNumbers = new AtomicLong(init);
	}

	public long add(final long num) {
		return sumOfSquaredNumbers.addAndGet(num);
	}

	public AtomicLong getSumOfSquaredNumbers() {
		return sumOfSquaredNumbers;
	}
	
	

}
