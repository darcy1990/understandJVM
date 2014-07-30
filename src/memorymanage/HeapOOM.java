package memorymanage;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zhongming.yuan
 *
 */
public class HeapOOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<HeapOOM> list = new ArrayList<HeapOOM>();
		
		while (true) {
			list.add(new HeapOOM());
		}
	}

}
