/*
 * treeSet�����࣬������������
 */
package Collect;

import java.util.TreeSet;

public class TreeSetTest01 {
	public static void main(String[] args)
	{
		/*
		 * treeSet���ú������Ĭ����������
		 */
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ts.add(5);
		ts.add(2);
		ts.add(9);
		ts.add(-4);
		System.out.println(ts);
		System.out.println(ts.first());//������ϵ�һ��Ԫ��
		System.out.println(ts.last());//����������һ��Ԫ��
		System.out.println(ts.headSet(5));//���ؼ�����С��5��Ԫ�أ�������5
		System.out.println(ts.tailSet(5));//���ؼ����ڴ���5��Ԫ�أ�����5
		System.out.println(ts.subSet(5, 9));//���ؼ�����[5,9)��Ԫ��
	}
}
