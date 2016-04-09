/*
 * Map������
 */
package Collect;

import java.util.*;

public class MapTest {
	public static void main(String[] args)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		/*
		 * map��keyֵ�����ظ���valueֵ���ظ�
		 */
		map.put("����", 110);
		map.put("��ѧ", 100);
		map.put("Ӣ��", 107);
		map.put("����", 107);
		System.out.println(map);
		/*
		 * �����ظ�Keyʱ���µ�value�Ḳ��ԭ�е�value
		 */
		map.put("����",110);
		System.out.println(map);
		/*
		 * �ж�map�Ƿ����ָ��key
		 */
		System.out.println(map.containsKey("����"));
		/*
		 * �ж�map�Ƿ����ָ��value
		 */
		System.out.println(map.containsValue(110));
		/*
		 * ��ȡMap���ϵ�����key��ɵļ��ϣ�ͨ������keyʵ�ֱ������е�key-value��
		 */
		for(Object key:map.keySet())
		{
			System.out.println(key+"--"+map.get(key));
		}
		/*
		 * ����key��ɾ��key-value��
		 */
		map.remove("Ӣ��");
		System.out.println(map);
	}
}
