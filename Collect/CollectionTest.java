/*
 * Collection������
 */
package Collect;

import java.util.*;

public class CollectionTest {
	public static void main(String[] args)
	{
		Collection c=new ArrayList();
		/*
		 * �򼯺����Ԫ�أ����ӷ���
		 */
		c.add("��˽�");
		c.add(6);
		System.out.println("c����Ԫ�ظ�����"+c.size());
		System.out.println("c�������Ƿ����\"��˽�\"��"+c.contains("��˽�"));//true
		c.add("����");
		Collection books=new HashSet();
		books.add("����");
		/*
		 * containsAll�ж�ĳ�����Ƿ������һ����
		 */
		System.out.println("c�����Ƿ���ȫ����books����?"+c.containsAll(books));//true
		 /*
		  * ĳ����ɾ������һ���ϵ��ظ�Ԫ��
		  */
		c.removeAll(books);
		System.out.println("��ӡc����:"+c);
		c.add("����");
		books.add("��ѧ");
		books.removeAll(c);
		System.out.println("��ӡbooks����:"+books);
	}
}
