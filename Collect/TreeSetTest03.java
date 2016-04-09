/*
 * treeSet自然排序2
 */
package Collect;

import java.util.TreeSet;

class R1 implements Comparable<Object>
{
	int count;
	public R1(int count)
	{
		this.count=count;
	}
	public String toString()
	{
		return "R[count:"+count+"]";
	}
	public boolean equals(Object o)
	{
		if(o==this)
			return true;
		if(o!=null&&o.getClass()==R1.class)
		{
			R1 r=(R1)o;
			return this.count==r.count;
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		R1 r=(R1)o;
		return this.count>r.count?1:count<r.count?-1:0;
	}
	
}
public class TreeSetTest03 {
	public static void main(String[] args)
	{
		TreeSet<Object> ts=new TreeSet<>();
		ts.add(new R1(9));
		ts.add(new R1(-9));
		ts.add(new R1(6));
		ts.add(new R1(4));
		System.out.println(ts);
		R1 first = (R1)ts.first();
		// 对第一个元素的count赋值
		first.count = 20;
		// 取出最后一个元素
		R1 last = (R1)ts.last();
		// 对最后一个元素的count赋值，与第二个元素的count相同
		last.count = -9;
		// 再次输出将看到TreeSet里的元素处于无序状态，且有重复元素
		System.out.println(ts);   
		// 删除实例变量被改变的元素，删除失败
		System.out.println(ts.remove(new R1(-9)));   
		System.out.println(ts);
		// 删除实例变量没有被改变的元素，删除成功
		System.out.println(ts.remove(new R1(6)));    
		System.out.println(ts);
	}

}
