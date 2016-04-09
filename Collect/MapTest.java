/*
 * Map测试类
 */
package Collect;

import java.util.*;

public class MapTest {
	public static void main(String[] args)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		/*
		 * map得key值不可重复，value值可重复
		 */
		map.put("语文", 110);
		map.put("数学", 100);
		map.put("英语", 107);
		map.put("物理", 107);
		System.out.println(map);
		/*
		 * 放入重复Key时，新的value会覆盖原有的value
		 */
		map.put("物理",110);
		System.out.println(map);
		/*
		 * 判断map是否包含指定key
		 */
		System.out.println(map.containsKey("物理"));
		/*
		 * 判断map是否包含指定value
		 */
		System.out.println(map.containsValue(110));
		/*
		 * 获取Map集合的所有key组成的集合，通过遍历key实现遍历所有的key-value对
		 */
		for(Object key:map.keySet())
		{
			System.out.println(key+"--"+map.get(key));
		}
		/*
		 * 根据key来删除key-value对
		 */
		map.remove("英语");
		System.out.println(map);
	}
}
