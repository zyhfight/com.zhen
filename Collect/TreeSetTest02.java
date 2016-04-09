/*
 * treeSet测试类，自然排序
 */
package Collect;

import java.util.TreeSet;

/*
 * 自然排序：实现Comparable接口，重写compareTo方法
 */
class Z implements Comparable<Object>
{
	 int age;
	public Z(){}
	public Z(int age){
		this.age=age;
	}
	/*
	 * 重写equals方法
	 */
	public boolean equals(Object obj){
		return true;
	}
	/*
	 * 重写toString方法
	 */
	public String toString()
	{
		return "Z[age:"+this.age+"]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
public class TreeSetTest02 {
	public static void main(String[] args)
	{
		TreeSet<Z> ts=new TreeSet<Z>();
		/*
		 * 虽然存入2个元素；但是却共享同一堆内存
		 */
		Z z1=new Z(6);
		ts.add(z1);
		System.out.println(ts.add(z1));
		System.out.println(ts);
		((Z)ts.first()).age=9;
		System.out.println(ts);
		System.out.println(((Z)ts.last()).age);
	}
}
