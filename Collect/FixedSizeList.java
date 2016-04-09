/*
 * Arrays提供asList方法，使其变为固长List；不可增删！
 */
package Collect;

import java.util.*;

public class FixedSizeList {
	public static void main(String[] args)
	{
		List<String> fixedList=Arrays.asList("语文","数学");
		/*
		 * asList属于Arrays$ArrayList类
		 */
		System.out.println(fixedList.getClass());
		for(String str:fixedList)
		{
			System.out.println(str);
		}
	}
}
