package Collect;

import java.util.TreeMap;

/*
 * 自然排序
 */
class R2 implements Comparable<Object>
{
	int count;
	public R2(int count)
	{
		this.count = count;
	}
	public String toString()
	{
		return "R[count:" + count + "]";
	}
	// 根据count来判断两个对象是否相等。
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj != null	&& obj.getClass() == R2.class)
		{
			R2 r = (R2)obj;
			return r.count == this.count;
		}
		return false;
	}
	// 根据count属性值来判断两个对象的大小。
	public int compareTo(Object obj)
	{
		R2 r = (R2)obj;
		return count > r.count ? 1 :
			count < r.count ? -1 : 0;
	}
}
public class TreeMapTest {
	public static void main(String[] args)
	{
		TreeMap<R2, String> tm=new TreeMap<R2, String>();
		tm.put(new R2(3) , "语文");
		tm.put(new R2(-5) , "数学");
		tm.put(new R2(9) , "英语");
		tm.put(new R2(4) , "语文");
		System.out.println(tm);
		/*
		 * 返回该TreeMap的第一个Entry对象
		 * key-value对以entry形式存在map中
		 */
		System.out.println(tm.firstEntry());
		/*
		 * 返回该TreeMap的最后一个key值
		 */
		System.out.println(tm.lastKey());
		/*
		 *  返回该TreeMap的比new R(2)大的最小key值。
		 */
		System.out.println(tm.higherKey(new R2(2)));
		/*
		 *  返回该TreeMap的比new R(2)小的最大的key-value对。
		 */
		System.out.println(tm.lowerEntry(new R2(2)));
		/*
		 *  返回该TreeMap的子TreeMap;左闭右开
		 */
		System.out.println(tm.subMap(new R2(-5) , new R2(4)));
	}
}
