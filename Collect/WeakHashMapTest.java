/*
 * WeakHashMap弱引用对象会被回收
 */
package Collect;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args)
	{
		WeakHashMap<String, String> whm = new WeakHashMap<String, String>();
		/*
		 * 
		 * 向WeakHashMap中添加三个key-value对，
		 * 三个key都是匿名字符串对象（没有其他引用）
		 * 
		 */
		whm.put(new String("语文") , new String("良好"));
		whm.put(new String("数学") , new String("及格"));
		whm.put(new String("英文") , new String("中等"));
		/*
		 * 将 WeakHashMap中添加一个key-value对，
		 * 该key是一个系统缓存的字符串对象。
		 */
		whm.put("java" , new String("中等"));    // ①
		System.out.println(whm);
		/*
		 *  通知系统立即进行垃圾回收；
		 *  只有key引用的key-value将被回收
		 */
		System.gc();
		System.runFinalization();
		System.out.println(whm);
	}
}
