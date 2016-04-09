/*
 * Iterator测试类
 */
package Collect;
import java.util.*;

public class IteratorTest {
	public static void main(String[] args)
	{
		Collection<String> books=new HashSet<String>();
		books.add("语文");
		books.add("数学");
		books.add("英语");
		/*
		 * 获取books集合对应的迭代器
		 */
		Iterator<String> it=books.iterator();
		while(it.hasNext())
		{
			/*
			 * it.next()方法返回Object类型，所以需强转
			 */
			String book=(String) it.next();
			/*
			 * 在使用迭代器器时，不可使用books.remove()方法
			 * 会破坏it.next()结构，导致异常
			 */
			System.out.println("获取的书名："+book);
			/*
			 * 从集合中删除next方法返回的元素
			 */
			if(book.equals("数学"))
				it.remove();
			/*
			 * 对book赋值，并不会改变集合元素本身；
			 */
			book="测试字符串";
	//		System.out.println("打印book："+book);
		}
		System.out.println("打印books:"+books);
	}
}
