package com.talesb.example.designpattern;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class FanOutFanIn {

	public static Long fanOutfanIn(List<SquareNumberRequest> requests, Consumer consumer) {

		ExecutorService service = Executors.newFixedThreadPool(requests.size());


		List<CompletableFuture<Void>> futures = requests.stream().map(
				request -> CompletableFuture.runAsync(()-> request.delaySquaring(consumer),service)
				).collect(Collectors.toList());
				
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
		
		return consumer.getSumOfSquaredNumbers().get();
	}

}
