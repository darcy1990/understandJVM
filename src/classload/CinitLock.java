package classload;

public class CinitLock {
	
	static class DeadLoopClass {
		static {
			if (true) {
				System.out.println(Thread.currentThread() + " init DeadLockClass");
				while (true) {
					
				}
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable script = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + " start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread() + " end");
			}
		};
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}

}
