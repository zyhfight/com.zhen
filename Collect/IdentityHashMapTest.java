/*
 * IdentityHashMapǿ���ڣ�a==b��ʱ�Ż���Ϊ���
 */
package Collect;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	public static void main(String[] args)
	{
		IdentityHashMap<String, Integer> ihm = new IdentityHashMap<String, Integer>();
		/*
		 * ���������ڲ�ͬ�ڴ�ռ䣬��Ϊ����
		 */
		ihm.put(new String("����") , 89);
		ihm.put(new String("����") , 78);
		/*
		 * ����java��ͬһ�����ڴ�ռ䣬�������
		 */
		ihm.put("java" , 93);
		ihm.put("java" , 98);
		System.out.println(ihm);
	}
}
