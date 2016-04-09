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
	 * ��дtoString����
	 */
	public String toString()
	{
		return "R[count:"+count+"]";
	}
	/*
	 * ��дequals����
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
	 * ��дhashCode����
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
		 * ���Ϸ����͵�������Ҫ����;
		 * 
		 */
		HashSet<Object> hs=new HashSet<>();
		hs.add(new R(5));
		hs.add(new R(-3));
		hs.add(new R(7));
		hs.add(new R(4));
		System.out.println(hs);
		/*
		 * ��ͬԪ���޷�����hs������
		 */
		hs.add(new R(5));
		/*
		 * �����ϵ�һ��Ԫ�ظ�ֵΪ5��
		 * ���������ظ�Ԫ�أ�
		 * ��ʱ��ֱ���ڶԼ���Ԫ�ظ�ֵ������ִ��equals��hashCode����
		 */
		Iterator<Object> it=hs.iterator();
		R first=(R) it.next();
		first.count=5;
		/*
		 * ��ʱֻ��ͨ��������ɾ������Ԫ�أ���������쳣
		 */
//		it.remove();
		System.out.println(hs);//��ʱ�������ظ�Ԫ��
		/*
		 * ɾ��������Ԫ��
		 */
		hs.remove(new R(5));//��ɾ��һ��RԪ��
		System.out.println(hs);

//		hs.remove(5);ɾ�����������κ�Ԫ��
		System.out.println("hs�����Ƿ����countΪ5��R����"+hs.contains(new R(5)));//false
//		System.out.println(hs);
	}
}
