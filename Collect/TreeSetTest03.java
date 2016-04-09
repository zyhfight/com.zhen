/*
 * treeSet��Ȼ����2
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
		// �Ե�һ��Ԫ�ص�count��ֵ
		first.count = 20;
		// ȡ�����һ��Ԫ��
		R1 last = (R1)ts.last();
		// �����һ��Ԫ�ص�count��ֵ����ڶ���Ԫ�ص�count��ͬ
		last.count = -9;
		// �ٴ����������TreeSet���Ԫ�ش�������״̬�������ظ�Ԫ��
		System.out.println(ts);   
		// ɾ��ʵ���������ı��Ԫ�أ�ɾ��ʧ��
		System.out.println(ts.remove(new R1(-9)));   
		System.out.println(ts);
		// ɾ��ʵ������û�б��ı��Ԫ�أ�ɾ���ɹ�
		System.out.println(ts.remove(new R1(6)));    
		System.out.println(ts);
	}

}
