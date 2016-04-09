/*
 * Collections提供系列静态方法对集合操作
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
		 * 输出集合最大、最小元素
		 */
		System.out.println(Collections.max(nums)); 
		System.out.println(Collections.min(nums)); 
		/*
		 * 将集合中所有0换为1
		 */
		Collections.replaceAll(nums , 0 , 1); 
		System.out.println(nums); 
		/*
		 *  判断-5在List集合中出现的次数，返回1
		 */
		System.out.println(Collections.frequency(nums , -5));
		Collections.sort(nums); 
		System.out.println(nums); 
		/*
		 * 只有排序后的List集合才可用二分法查询，输出3
		 */
		System.out.println(Collections.binarySearch(nums , 3));
	}
}
