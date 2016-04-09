/*
 * HashSet测试类
 */
package Collect;

import java.util.HashSet;

/*
 * 类A重写equals方法。总是返回true，未重写hashCode方法
 */
class A
{
	public boolean equals(Object obj)
	{
		return true;
	}
}
/*
 * 类B重写hashCode方法，未重写equals方法
 */
class B
{
	public int hashCode()
	{
		return 1;
	}
}
/*
 * 类C重写了hashCode、equals方法
 */
class C
{
	public int hashCode()
	{
		return 2;
	}
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class HashSetTest01 {
	public static void main(String[] args)
	{
		HashSet<Object> objs=new HashSet<Object>();
		/*
		 * hashCode、equals方法均相同则认为元素相同，hashSet存储无序、不重复元素。
		 */
		objs.add(new A());
		objs.add(new A());
		objs.add(new B());
		objs.add(new B());
		objs.add(new C());
		objs.add(new C());
		System.out.println(objs);
	}
}
