/*
 * ArrayDeque�����ࣻ
 * ˫�˶��У�����ջ���������ж��е�����
 * ���̰߳�ȫ������ջ����stack���������п���LinkedList
 */
package Collect;

import java.util.ArrayDeque;

public class ArrayDequeQueue {
	public static void main(String[] args)
	{
		ArrayDeque<String> queue=new ArrayDeque<String>();
		queue.offer("����");
		queue.offer("��ѧ");
		queue.offer("Ӣ��");
		System.out.println(queue);
		/*
		 * ��ȡ���е�һ��Ԫ�أ������Ƴ�
		 */
		System.out.println(queue.peek());
	}
}
