/*
 * LinkedHashSet������
 */
package Collect;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args)
	{
		/*
		 * LinkedHashSet��������ʽά������Ԫ�ز���˳��
		 */
		LinkedHashSet<String> books=new LinkedHashSet<>();
		books.add("��ѧ");
		books.add("����");
		books.add("Ӣ��");
		System.out.println(books);
		books.remove("����");
		books.add("����");
		System.out.println(books);	
	}

}
