package memorymanage;

/**
 * @author zhongming.yuan
 * stack depth requested by thread exceeds depth allowed by jvm
 */
public class JavaVMStackSOF {
	
	private int stacklength = 1;
	
	public void stackLeak() {
		stacklength ++;
		stackLeak();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println(oom.stacklength);
			throw e;
		}
	}

}
