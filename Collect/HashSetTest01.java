/*
 * HashSet������
 */
package Collect;

import java.util.HashSet;

/*
 * ��A��дequals���������Ƿ���true��δ��дhashCode����
 */
class A
{
	public boolean equals(Object obj)
	{
		return true;
	}
}
/*
 * ��B��дhashCode������δ��дequals����
 */
class B
{
	public int hashCode()
	{
		return 1;
	}
}
/*
 * ��C��д��hashCode��equals����
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
		 * hashCode��equals��������ͬ����ΪԪ����ͬ��hashSet�洢���򡢲��ظ�Ԫ�ء�
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
