package classload;

/**
 * �ֲ�������Slot��gc��Ӱ��
 * @author zhongming.yuan
 * @date 2014-12-14
 * VM args: -verbose:gc
 */
public class GCVsLocalVariableSlot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		{
		byte[] placeholder = new byte[64 * 1024 * 1024];
		}
//		int a = 0;
		System.gc();
	}

}
