/*
 * PriorityQueue������
 * ����Ԫ�ش�С������С�
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
		 * ��ȡ���Ƴ����е�һ��Ԫ��
		 */
		System.out.println(pq.poll());
	}
}
