package keesun.chap6;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		});
		thread.start();
		
		System.out.println("Hello : " + Thread.currentThread().getName());
		thread.join();
		System.out.println(thread + "is finished");
	}

}
