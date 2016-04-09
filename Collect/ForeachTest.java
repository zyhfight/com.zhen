/*
 * foreach测试类
 */
package Collect;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
	public static void main(String[] args)
	{
		Collection<Object> books=new HashSet<>();
		books.add("语文");
		books.add("数学");
		books.add("英语");
		System.out.print("集合中元素：");
		/*
		 * foreach一般只用于遍历集合元素
		 */
		for(Object ob:books)
		{
			System.out.print(ob+" ");
			
		//下面代码会引发ConcurrentModificationException 
		/*	if(ob.equals("语文"))
				books.remove(ob);*/
		}
		System.out.println();
		System.out.println(books);
	}
}
