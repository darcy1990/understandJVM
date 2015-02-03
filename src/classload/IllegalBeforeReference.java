package classload;

public class IllegalBeforeReference {
	
	static {
		i = 0;
//		System.out.println(i); // Cannot reference a field before it is defined
	}
	
	static int i = 1;

}
