/*
 * Collections可设置集合不可变
 */
package Collect;

import java.util.*;

public class UnmodifiableTest {
	public static void main(String[] args)
	{
		/*
		 * 创建一个空的，不可改变的List对象
		 */
		List unmodifiableList=Collections.emptyList();
		/*
		 * 创建只有一个元素，且不可改变的set对象
		 */
		Set unmodifiableSet=Collections.singleton("单体对象");
		/*
		 * 创建一个普通Map对象
		 */
		Map<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("语文" , 80);
		scores.put("Java" , 82);
		/*
		 * 返回scores的不可变版本
		 */
		Map unmodifiableMap=Collections.unmodifiableMap(scores);
		
	}
}
