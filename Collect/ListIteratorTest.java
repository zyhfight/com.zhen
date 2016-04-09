/*
 * ListIterator�����ࣻ
 * �ɷ������
 */
package Collect;
import java.util.*;

public class ListIteratorTest {
	public static void main(String[] args)
	{
		String[] books={"����","��ѧ","Ӣ��"};
		List<String> bookList=new ArrayList<String>();
		for(int i=0;i<books.length;i++)
		{
			bookList.add(books[i]);
		}
		ListIterator<String> lit=bookList.listIterator();
		while(lit.hasNext())
		{
			System.out.println(lit.next());
		}
		lit.add("------�ָ���------");
		/*
		 * �������
		 */
		while(lit.hasPrevious())
		{
			System.out.println(lit.previous());
		}
	}
}
