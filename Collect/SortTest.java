package Collect;

import java.util.ArrayList;

import java.util.Collections;

public class SortTest {
	public static void main(String[] args)
	{
		ArrayList<Integer> nums=new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(8);
		nums.add(0);
		System.out.println(nums);
		/*
		 * ��ת����Ԫ��
		 */
		Collections.reverse(nums);
		System.out.println(nums);
		/*
		 *���򼯺�Ԫ�� ������
		 */
		Collections.sort(nums);
		System.out.println(nums);
		/*
		 *������м���Ԫ�� ��ÿ�β�ͬ
		 */
		Collections.shuffle(nums);
		System.out.println(nums);
		
	}
}
