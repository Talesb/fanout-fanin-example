package com.talesb.example.regular;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.talesb.example.designpattern.Consumer;

public class FanInFanOutService {

	public static Long fanOutfanIn(List<Long> numbers, Consumer consumer) {
		List<CompletableFuture>futures = new ArrayList<>();
		   ExecutorService threadPool = Executors.newFixedThreadPool(numbers.size());
		for (Long number : numbers) {
			Thread newThread = new Thread(() -> {
				consumer.add(number * number);
			});
			futures.add(CompletableFuture.runAsync(newThread,threadPool));
		}
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
		
		return consumer.getSumOfSquaredNumbers().get();
	}

}
