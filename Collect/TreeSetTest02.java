/*
 * treeSet�����࣬��Ȼ����
 */
package Collect;

import java.util.TreeSet;

/*
 * ��Ȼ����ʵ��Comparable�ӿڣ���дcompareTo����
 */
class Z implements Comparable<Object>
{
	 int age;
	public Z(){}
	public Z(int age){
		this.age=age;
	}
	/*
	 * ��дequals����
	 */
	public boolean equals(Object obj){
		return true;
	}
	/*
	 * ��дtoString����
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
		 * ��Ȼ����2��Ԫ�أ�����ȴ����ͬһ���ڴ�
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
