package gc;

public class GC {
	
	private static final int  _1MB = 1024 * 1024;
	
	/**
	 * VM parameter
	 * -verbose:gc
	 * -Xms 20M
	 * -Xmx 20M
	 * -Xmn 10M
	 * -XX:+PrintGCDetails
	 * -XX:SurvivorRatio = 8
	 */
	@SuppressWarnings("unused")
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];
	}
	
	/**
	 * VM parameter
	 * -verbose:gc
	 * -Xms 20M
	 * -Xmx 20M
	 * -Xmn 10M
	 * -XX:+PrintGCDetails
	 * -XX:SurvivorRatio = 8
	 * -XX:PretenureSizeThreshold = 3145728
	 */
	@SuppressWarnings("unused")
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB]; 
	}
	
	/**
	 * VM parameter
	 * -verbose:gc
	 * -Xms 20M
	 * -Xmx 20M
	 * -Xmn 10M
	 * -XX:+PrintGCDetails
	 * -XX:SurvivorRatio = 8
	 * -XX:MaxTenuringThreshold = 1
	 * -XX:+PrintTenuringDistribution
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}
	
	/**
	 * VM parameter
	 * -verbose:gc
	 * -Xms 20M
	 * -Xmx 20M
	 * -Xmn 10M
	 * -XX:+PrintGCDetails
	 * -XX:SurvivorRatio = 8
	 * -XX:MaxTenuringThreshold = 15
	 * -XX:+PrintTenuringDistribution
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[_1MB / 4];
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
	}
	
	/**
	 * VM parameter
	 * -verbose:gc
	 * -Xms 20M
	 * -Xmx 20M
	 * -Xmn 10M
	 * -XX:+PrintGCDetails
	 * -XX:SurvivorRatio = 8
	 * -XX:-HandlePromotionFailure
	 */
	@SuppressWarnings("unused")
	public static void testHandlePromotion() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation1 = null;
		allocation4 = new byte[2 * _1MB];// hey,man,we've got 6M + 2M, so we need a gc to move 6M to old gen
		allocation5 = new byte[2 * _1MB];
		allocation6 = new byte[2 * _1MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * _1MB];// oh,gosh,wo are to get 8M again and the average size of object >= before, so we need a full gc
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testAllocation();
//		testPretenureSizeThreshold();
//		testTenuringThreshold();
		testHandlePromotion();
	}

}
/**
 * common VM parameter
 * -verbose:gc
 * -Xms 初始Java堆大小
 * -Xmx 最大Java堆大小
 * -Xmn 年轻代大小
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio = Eden/Survivorfgv uj
 * 
 */
