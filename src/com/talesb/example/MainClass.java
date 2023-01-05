package com.talesb.example;

import java.util.List;

import com.talesb.example.designpattern.Consumer;
import com.talesb.example.designpattern.FanOutFanIn;
import com.talesb.example.designpattern.SquareNumberRequest;

public class MainClass {

	public static void main(String[] args) {

		SquareNumberRequest request1 = new SquareNumberRequest();
		request1.setNumber(2L);

		SquareNumberRequest request2 = new SquareNumberRequest();
		request2.setNumber(3L);

		Long sum = FanOutFanIn.fanOutfanIn(List.of(request1, request2), new Consumer(0L));
		System.out.println(sum);

	}
}
