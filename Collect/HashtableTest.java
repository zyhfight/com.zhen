package Collect;

import java.util.Hashtable;

class A1
{
	int count;
	public A1(int count)
	{
		this.count = count;
	}
	// ����count��ֵ���ж����������Ƿ���ȡ�
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (obj != null && obj.getClass() == A1.class)
		{
			A1 a = (A1)obj;
			return this.count == a.count;
		}
		return false;
	}
	// ����count������hashCodeֵ��
	public int hashCode()
	{
		return this.count;
	}
}
class B1
{
	// ��дequals()������B�������κζ���ͨ��equals()�����Ƚ϶�����true
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class HashtableTest
{
	public static void main(String[] args)
	{
		Hashtable<A1, Object> ht = new Hashtable<A1, Object>();
		ht.put(new A1(60000) , "����");
		ht.put(new A1(87563) , "��ѧ");
		ht.put(new A1(1232) , new B1());
		/*
		 * HashTable�̰߳�ȫ��key��valueֵ������Ϊnull������NullPointerException
		 */
//		ht.put(null, null);
		System.out.println(ht);
		// ֻҪ��������ͨ��equals�ȽϷ���true��
		// Hashtable����Ϊ��������ȵ�value��
		// ����Hashtable����һ��B����
		// �����κζ���ͨ��equals�Ƚ϶���ȣ������������true��
		System.out.println(ht.containsValue("�����ַ���")); // �� ���true
		// ֻҪ����A�����count��ȣ�����ͨ��equals�ȽϷ���true����hashCode���
		// Hashtable����Ϊ��������ͬ��key�������������true��
		System.out.println(ht.containsKey(new A1(87563)));   // �� ���true
		// ����������ɾ�����һ��key-value��
		ht.remove(new A1(1232));    //��
		System.out.println(ht);
	}
}
