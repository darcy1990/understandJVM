package classload;

public class NotInitialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SubClass.value); // SubClass not initialized
		
		SuperClass[] sca = new SuperClass[10]; // SuperClass not initialized
		
		System.out.println(ConstClass.HELLOWORLD); // ConstClass not initialized
	}

}
