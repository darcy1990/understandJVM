package memorymanage;

/**
 * use jdk1.6 and jdk1.7 to see the difference
 * @author zhongming.yuan
 *
 */
public class RuntimeConstantPoolIntern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = new StringBuilder("¼ÆËã»ú").append("Èí¼þ").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}

}
