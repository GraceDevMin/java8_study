package keesun.chap6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class execute {

	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
//		executorService.submit(() -> {
//			System.out.println("Thread " + Thread.currentThread().getName());
//		});
	
//		executorService.shutdown();
		
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		executorService.submit(getRunnable("Hello"));
//		executorService.submit(getRunnable("Keesun"));
//		executorService.submit(getRunnable("The"));
//		executorService.submit(getRunnable("Java"));
//		executorService.submit(getRunnable("Thread"));
		
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
	}

	private static Runnable getRunnable(String message) {
		return () -> System.out.println(message + Thread.currentThread().getName());	//Runnable은 void cf. Callable
	}
}
