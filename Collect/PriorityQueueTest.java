/*
 * PriorityQueue测试类
 * 按照元素大小存入队列。
 */
package Collect;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args)
	{
		PriorityQueue<Object> pq=new PriorityQueue<>();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(12);
		pq.offer(9);
		System.out.println(pq);
		/*
		 * 获取并移除队列第一个元素
		 */
		System.out.println(pq.poll());
	}
}
