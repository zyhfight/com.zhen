/*
 * List������
 */
package Collect;
import java.util.*;

public class ListTest {
	public static void main(String[] args)
	{
		List<String> books=new ArrayList<String>();
		books.add(new String("����"));
		books.add(new String("��ѧ"));
		books.add(new String("Ӣ��"));
		System.out.println(books);
		/*
		 * ����������ڵڶ���λ��
		 */
		books.add(1, new String("����"));
		for(int i=0;i<books.size();i++)
		{
			System.out.println(books.get(i));
		}
		/*
		 * ��ȡ������List�е�λ��
		 */
		System.out.println(books.indexOf(new String("����")));
		/*
		 * ��List�еڶ���Ԫ�ػ�����ѧ
		 */
		books.set(1, new String("��ѧ"));
		System.out.println(books);
		/*
		 * ��ȡList�е�[1,2)��
		 */
		System.out.println(books.subList(1, 2));
		/*
		 * ɾ��List������Ԫ��
		 */
		books.remove(new String("����"));
		System.out.println(books);
		/*
		 * ɾ��List�еڶ���Ԫ��
		 */
		books.remove(1);
		System.out.println(books);
	}
}
