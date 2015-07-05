package btrace;

public class BTraceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			consumeTime();
		}
	}
	
	private static void consumeTime() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("do the real matter");
	}

}
