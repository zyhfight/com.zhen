/*
 * Collection��ͬ������
 */
package Collect;

import java.util.*;

public class SynchronizedTest {
	public static void main(String[] args)
	{
		/*
		 * ������򴴽����ĸ��̰߳�ȫ�ļ��϶���
		 */
		Collection c = Collections.synchronizedCollection(new ArrayList());
		List list = Collections.synchronizedList(new ArrayList());
		Set s = Collections.synchronizedSet(new HashSet());
		Map m = Collections.synchronizedMap(new HashMap());
	}
}
