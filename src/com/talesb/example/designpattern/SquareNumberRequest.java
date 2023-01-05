package com.talesb.example.designpattern;

import java.security.SecureRandom;

public class SquareNumberRequest {

	private Long number;

	public void delaySquaring(final Consumer consumer) {

	    var minTimeOut = 5000L;

	    SecureRandom random = new SecureRandom();
	    var randomTimeOut = random.nextInt(2000);

	    try {
	      // this will make the thread sleep from 5-7s.
	      Thread.sleep(minTimeOut + randomTimeOut);
	    } catch (InterruptedException e) {
	      Thread.currentThread().interrupt();
	    } finally {
	      consumer.add(number * number);
	    }

	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	

}
