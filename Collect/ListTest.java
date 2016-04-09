/*
 * List测试类
 */
package Collect;
import java.util.*;

public class ListTest {
	public static void main(String[] args)
	{
		List<String> books=new ArrayList<String>();
		books.add(new String("语文"));
		books.add(new String("数学"));
		books.add(new String("英语"));
		System.out.println(books);
		/*
		 * 将物理插入在第二个位置
		 */
		books.add(1, new String("物理"));
		for(int i=0;i<books.size();i++)
		{
			System.out.println(books.get(i));
		}
		/*
		 * 获取物理在List中的位置
		 */
		System.out.println(books.indexOf(new String("物理")));
		/*
		 * 将List中第二个元素换成数学
		 */
		books.set(1, new String("数学"));
		System.out.println(books);
		/*
		 * 截取List中的[1,2)段
		 */
		System.out.println(books.subList(1, 2));
		/*
		 * 删除List中语文元素
		 */
		books.remove(new String("语文"));
		System.out.println(books);
		/*
		 * 删除List中第二个元素
		 */
		books.remove(1);
		System.out.println(books);
	}
}
