/*
 * LinkedList测试类
 * LinkedList既有堆栈又有队列性质
 */
package Collect;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args)
	{
		LinkedList<Object> books=new LinkedList<>();
		/*
		 * 将语文加入队列的尾部
		 */
		books.offer("语文");
		/*
		 * 将数学加入栈的顶部
		 */
		books.push("数学");
		books.offer("英语");
		/*
		 * 将历史加入队列顶部（相当于栈顶部）
		 */
		books.offerFirst("历史");
		System.out.println(books);
		/*
		 * 访问、并不删除队列第一个元素
		 */
		System.out.println(books.peekFirst());
		/*
		 * 访问、并不删除队列最后一个元素
		 */
		System.out.println(books.peekLast());
		/*
		 * 访问并删除队列最后一个元素
		 */
		System.out.println(books.pollLast());
		System.out.println(books);
	}
	

}
