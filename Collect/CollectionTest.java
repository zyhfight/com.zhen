/*
 * Collection测试类
 */
package Collect;

import java.util.*;

public class CollectionTest {
	public static void main(String[] args)
	{
		Collection c=new ArrayList();
		/*
		 * 向集合添加元素，不加泛型
		 */
		c.add("猪八戒");
		c.add(6);
		System.out.println("c集合元素个数："+c.size());
		System.out.println("c集合中是否包含\"猪八戒\"："+c.contains("猪八戒"));//true
		c.add("语文");
		Collection books=new HashSet();
		books.add("语文");
		/*
		 * containsAll判断某集合是否包含另一集合
		 */
		System.out.println("c集合是否完全包含books集合?"+c.containsAll(books));//true
		 /*
		  * 某集合删除与另一集合的重复元素
		  */
		c.removeAll(books);
		System.out.println("打印c集合:"+c);
		c.add("语文");
		books.add("数学");
		books.removeAll(c);
		System.out.println("打印books集合:"+books);
	}
}
