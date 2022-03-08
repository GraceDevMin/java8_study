package keesun.chap6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};
		
		Future<String> helloFuture = executorService.submit(hello);

		System.out.println("Started!");
		
		helloFuture.cancel(false);	//cancel을 하면 true든, false든 get을 할 수 없음
		
		System.out.println(helloFuture.isDone());
		
//		helloFuture.get();	//여기를 만나는 순간.. 결과값을 가져올때 까지 기다림 --> 블록킹 콜
		
		System.out.println(helloFuture.isDone());
		System.out.println("End!");
		executorService.shutdown();
		
	}

	
}
