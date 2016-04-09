/*
 * ArrayDeque测试类；
 * 双端队列，即有栈的性质又有队列的性质
 * 非线程安全，用作栈快于stack，用作队列快于LinkedList
 */
package Collect;

import java.util.ArrayDeque;

public class ArrayDequeQueue {
	public static void main(String[] args)
	{
		ArrayDeque<String> queue=new ArrayDeque<String>();
		queue.offer("语文");
		queue.offer("数学");
		queue.offer("英语");
		System.out.println(queue);
		/*
		 * 获取队列第一个元素，但不移除
		 */
		System.out.println(queue.peek());
	}
}
