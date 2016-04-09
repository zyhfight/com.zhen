/*
 * Collections�ṩϵ�о�̬�����Լ��ϲ���
 */
package Collect;

import java.util.ArrayList;
import java.util.Collections;

public class SearchTest {
	public static void main(String[] args)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		System.out.println(nums); 
		/*
		 * ������������СԪ��
		 */
		System.out.println(Collections.max(nums)); 
		System.out.println(Collections.min(nums)); 
		/*
		 * ������������0��Ϊ1
		 */
		Collections.replaceAll(nums , 0 , 1); 
		System.out.println(nums); 
		/*
		 *  �ж�-5��List�����г��ֵĴ���������1
		 */
		System.out.println(Collections.frequency(nums , -5));
		Collections.sort(nums); 
		System.out.println(nums); 
		/*
		 * ֻ��������List���ϲſ��ö��ַ���ѯ�����3
		 */
		System.out.println(Collections.binarySearch(nums , 3));
	}
}
