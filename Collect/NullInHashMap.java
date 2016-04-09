/*
 * hashMap允许key、value为null
 */
package Collect;

import java.util.HashMap;

public class NullInHashMap {
	public static void main(String[] args)
	{
		HashMap<String, Object> hm = new HashMap<String, Object>();
		/*
		 * 将key为null的key-value对放入HashMap中
		 */
		hm.put(null , null);
		/*
		 *  将一个value为null的key-value对放入HashMap中
		 */
		hm.put("a" , null); 
		// 输出Map对象
		System.out.println(hm);
	}
}
