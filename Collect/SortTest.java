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
		 * 反转集合元素
		 */
		Collections.reverse(nums);
		System.out.println(nums);
		/*
		 *排序集合元素 ；升序
		 */
		Collections.sort(nums);
		System.out.println(nums);
		/*
		 *随机排列集合元素 ；每次不同
		 */
		Collections.shuffle(nums);
		System.out.println(nums);
		
	}
}
