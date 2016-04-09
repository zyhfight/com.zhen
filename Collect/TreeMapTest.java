package Collect;

import java.util.TreeMap;

/*
 * ��Ȼ����
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
	// ����count���ж����������Ƿ���ȡ�
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
	// ����count����ֵ���ж���������Ĵ�С��
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
		tm.put(new R2(3) , "����");
		tm.put(new R2(-5) , "��ѧ");
		tm.put(new R2(9) , "Ӣ��");
		tm.put(new R2(4) , "����");
		System.out.println(tm);
		/*
		 * ���ظ�TreeMap�ĵ�һ��Entry����
		 * key-value����entry��ʽ����map��
		 */
		System.out.println(tm.firstEntry());
		/*
		 * ���ظ�TreeMap�����һ��keyֵ
		 */
		System.out.println(tm.lastKey());
		/*
		 *  ���ظ�TreeMap�ı�new R(2)�����Сkeyֵ��
		 */
		System.out.println(tm.higherKey(new R2(2)));
		/*
		 *  ���ظ�TreeMap�ı�new R(2)С������key-value�ԡ�
		 */
		System.out.println(tm.lowerEntry(new R2(2)));
		/*
		 *  ���ظ�TreeMap����TreeMap;����ҿ�
		 */
		System.out.println(tm.subMap(new R2(-5) , new R2(4)));
	}
}
