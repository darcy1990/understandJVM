package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	
	public static volatile AtomicInteger race = new AtomicInteger(0);
	
	public static void increase() {
		race.incrementAndGet();
	}
	
	private static final int THREAD_COUNT = 20;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread[] threads = new Thread[THREAD_COUNT];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 10000; j++) {
						increase();
					}
				}
			});
			threads[i].start();
		}
		
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		
		System.out.println(race);
	}

}
