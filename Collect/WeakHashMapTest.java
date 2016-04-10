/*
 * WeakHashMap�����ö���ᱻ����
 */
package Collect;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args)
	{
		WeakHashMap<String, String> whm = new WeakHashMap<String, String>();
		/*
		 * 
		 * ��WeakHashMap���������key-value�ԣ�
		 * ����key���������ַ�������û���������ã�
		 * 
		 */
		whm.put(new String("����") , new String("����"));
		whm.put(new String("��ѧ") , new String("����"));
		whm.put(new String("Ӣ��") , new String("�е�"));
		/*
		 * �� WeakHashMap�����һ��key-value�ԣ�
		 * ��key��һ��ϵͳ������ַ�������
		 * "java"�ڳ������ʱ�ͷ��䳣���ڴ�ռ䣬�������ڳ������ã�
		 * �˴����������������ã����ɶ������ͬһ�ڴ�ռ䣩���Ϊǿ���ã�
		 * e.g��String a="abc"�����г������ã�Ҳ��a���ã�
		 */
		whm.put("java" , new String("�е�"));    // ��
		System.out.println(whm);
		/*
		 *  ֪ͨϵͳ���������������գ�
		 *  ֻ��key���õ�key-value��������
		 */
		System.gc();
		System.runFinalization();
		System.out.println(whm);
	}
}
