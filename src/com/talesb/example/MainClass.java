package com.talesb.example;

import java.util.List;

import com.talesb.example.designpattern.Consumer;
import com.talesb.example.regular.FanInFanOutService;

public class MainClass {

	public static void main(String[] args) {

//		SquareNumberRequest request1 = new SquareNumberRequest();
//		request1.setNumber(2L);
//
//		SquareNumberRequest request2 = new SquareNumberRequest();
//		request2.setNumber(3L);
//
//		SquareNumberRequest request3 = new SquareNumberRequest();
//		request3.setNumber(5L);
//
//		SquareNumberRequest request4 = new SquareNumberRequest();
//		request4.setNumber(7L);
//		
//		Long sum = FanOutFanIn.fanOutfanIn(List.of(request1, request2,request3,request4), new Consumer(0L));
//		System.out.println(sum);
		
		
		Long sum = FanInFanOutService.fanOutfanIn(List.of(2L, 3L,5L,7L), new Consumer(0L));
		System.out.println(sum);
	}
}
