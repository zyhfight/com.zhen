/*
 * Arrays�ṩasList������ʹ���Ϊ�̳�List��������ɾ��
 */
package Collect;

import java.util.*;

public class FixedSizeList {
	public static void main(String[] args)
	{
		List<String> fixedList=Arrays.asList("����","��ѧ");
		/*
		 * asList����Arrays$ArrayList��
		 */
		System.out.println(fixedList.getClass());
		for(String str:fixedList)
		{
			System.out.println(str);
		}
	}
}
