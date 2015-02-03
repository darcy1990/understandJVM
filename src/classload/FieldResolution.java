package classload;

public class FieldResolution {
	
	interface Interface0 {
		int A = 0;
	}
	
	interface Interface1 extends Interface0 {
		int A = 1;
	}
	
	interface Interface2 {
		int A = 2;
	}
	
	static class Parent implements Interface1 {
		public static int A = 3;
	}
	
	static class Sub extends Parent implements Interface2 {
//		public static int A = 4;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Sub.A); // The field Sub.A is ambiguous
	}

}
