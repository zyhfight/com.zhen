/*
 * treeSet测试类，基本数据类型
 */
package Collect;

import java.util.TreeSet;

public class TreeSetTest01 {
	public static void main(String[] args)
	{
		/*
		 * treeSet采用红黑树，默认升序排列
		 */
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ts.add(5);
		ts.add(2);
		ts.add(9);
		ts.add(-4);
		System.out.println(ts);
		System.out.println(ts.first());//输出集合第一个元素
		System.out.println(ts.last());//输出集合最后一个元素
		System.out.println(ts.headSet(5));//返回集合内小于5的元素，不包括5
		System.out.println(ts.tailSet(5));//返回集合内大于5的元素，包括5
		System.out.println(ts.subSet(5, 9));//返回集合内[5,9)的元素
	}
}
