/*
 * LinkedHashSet测试类
 */
package Collect;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args)
	{
		/*
		 * LinkedHashSet以链表形式维护插入元素插入顺序
		 */
		LinkedHashSet<String> books=new LinkedHashSet<>();
		books.add("数学");
		books.add("语文");
		books.add("英语");
		System.out.println(books);
		books.remove("语文");
		books.add("语文");
		System.out.println(books);	
	}

}
