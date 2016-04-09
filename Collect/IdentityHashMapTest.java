/*
 * IdentityHashMap强等于（a==b）时才会认为相等
 */
package Collect;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	public static void main(String[] args)
	{
		IdentityHashMap<String, Integer> ihm = new IdentityHashMap<String, Integer>();
		/*
		 * 两个语文在不同内存空间，认为不等
		 */
		ihm.put(new String("语文") , 89);
		ihm.put(new String("语文") , 78);
		/*
		 * 两个java在同一常量内存空间，任务相等
		 */
		ihm.put("java" , 93);
		ihm.put("java" , 98);
		System.out.println(ihm);
	}
}
