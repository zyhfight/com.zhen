/*
 * foreach������
 */
package Collect;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
	public static void main(String[] args)
	{
		Collection<Object> books=new HashSet<>();
		books.add("����");
		books.add("��ѧ");
		books.add("Ӣ��");
		System.out.print("������Ԫ�أ�");
		/*
		 * foreachһ��ֻ���ڱ�������Ԫ��
		 */
		for(Object ob:books)
		{
			System.out.print(ob+" ");
			
		//������������ConcurrentModificationException 
		/*	if(ob.equals("����"))
				books.remove(ob);*/
		}
		System.out.println();
		System.out.println(books);
	}
}
