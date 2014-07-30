package memorymanage;

import java.util.ArrayList;
import java.util.List;

/**
 * too many constants
 * @author zhongming.yuan
 *
 */
public class RuntimeConstantPoolOOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}
