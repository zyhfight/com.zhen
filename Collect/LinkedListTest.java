/*
 * LinkedList������
 * LinkedList���ж�ջ���ж�������
 */
package Collect;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args)
	{
		LinkedList<Object> books=new LinkedList<>();
		/*
		 * �����ļ�����е�β��
		 */
		books.offer("����");
		/*
		 * ����ѧ����ջ�Ķ���
		 */
		books.push("��ѧ");
		books.offer("Ӣ��");
		/*
		 * ����ʷ������ж������൱��ջ������
		 */
		books.offerFirst("��ʷ");
		System.out.println(books);
		/*
		 * ���ʡ�����ɾ�����е�һ��Ԫ��
		 */
		System.out.println(books.peekFirst());
		/*
		 * ���ʡ�����ɾ���������һ��Ԫ��
		 */
		System.out.println(books.peekLast());
		/*
		 * ���ʲ�ɾ���������һ��Ԫ��
		 */
		System.out.println(books.pollLast());
		System.out.println(books);
	}
	

}
