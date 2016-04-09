package Collect;

import java.util.HashSet;
import java.util.Iterator;

class R
{
	public int count;
	public R(){}
	public R(int count)
	{
		this.count=count;
	}
	/*
	 * 重写toString方法
	 */
	public String toString()
	{
		return "R[count:"+count+"]";
	}
	/*
	 * 重写equals方法
	 */
	public boolean equals(Object obj)
	{
		if(obj==this)
			return true;
		if(obj!=null&&obj.getClass()==R.class)
		{
			R r=(R) obj;
			return r.count==this.count;
		}
		return false;
	}
	/*
	 * 重写hashCode方法
	 */
	public int hashCode()
	{
		return this.count;
	}
}
public class HashSetTest02 {
	public static void main(String[] args)
	{
		/*
		 * 集合方法和迭代器不要混用;
		 * 
		 */
		HashSet<Object> hs=new HashSet<>();
		hs.add(new R(5));
		hs.add(new R(-3));
		hs.add(new R(7));
		hs.add(new R(4));
		System.out.println(hs);
		/*
		 * 相同元素无法加入hs集合中
		 */
		hs.add(new R(5));
		/*
		 * 将集合第一个元素赋值为5；
		 * 集合中有重复元素；
		 * 此时是直接在对集合元素赋值，不会执行equals、hashCode方法
		 */
		Iterator<Object> it=hs.iterator();
		R first=(R) it.next();
		first.count=5;
		/*
		 * 此时只能通过迭起器删除集合元素，否则会有异常
		 */
//		it.remove();
		System.out.println(hs);//此时集合有重复元素
		/*
		 * 删除集合内元素
		 */
		hs.remove(new R(5));//会删掉一个R元素
		System.out.println(hs);

//		hs.remove(5);删不掉集合内任何元素
		System.out.println("hs集合是否包含count为5的R对象："+hs.contains(new R(5)));//false
//		System.out.println(hs);
	}
}
