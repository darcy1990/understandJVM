package tools;

import java.util.ArrayList;
import java.util.List;

public class JConsoleMemory {

	/**
	 * �ڴ�ռλ������һ��OOMObject��Լռ64K
	 */
	static class OOMObject {
		public byte[] placeholder = new byte[64 * 1024];
	}

	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			// ������ʱ����������ߵı仯��������
			Thread.sleep(50);
			list.add(new OOMObject());
		}
	}

	public static void main(String[] args) throws Exception {
		fillHeap(1000);
		System.gc();
	}

}
