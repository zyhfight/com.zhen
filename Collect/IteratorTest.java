/*
 * Iterator������
 */
package Collect;
import java.util.*;

public class IteratorTest {
	public static void main(String[] args)
	{
		Collection<String> books=new HashSet<String>();
		books.add("����");
		books.add("��ѧ");
		books.add("Ӣ��");
		/*
		 * ��ȡbooks���϶�Ӧ�ĵ�����
		 */
		Iterator<String> it=books.iterator();
		while(it.hasNext())
		{
			/*
			 * it.next()��������Object���ͣ�������ǿת
			 */
			String book=(String) it.next();
			/*
			 * ��ʹ�õ�������ʱ������ʹ��books.remove()����
			 * ���ƻ�it.next()�ṹ�������쳣
			 */
			System.out.println("��ȡ��������"+book);
			/*
			 * �Ӽ�����ɾ��next�������ص�Ԫ��
			 */
			if(book.equals("��ѧ"))
				it.remove();
			/*
			 * ��book��ֵ��������ı伯��Ԫ�ر���
			 */
			book="�����ַ���";
	//		System.out.println("��ӡbook��"+book);
		}
		System.out.println("��ӡbooks:"+books);
	}
}
