/*
 * Collections�����ü��ϲ��ɱ�
 */
package Collect;

import java.util.*;

public class UnmodifiableTest {
	public static void main(String[] args)
	{
		/*
		 * ����һ���յģ����ɸı��List����
		 */
		List unmodifiableList=Collections.emptyList();
		/*
		 * ����ֻ��һ��Ԫ�أ��Ҳ��ɸı��set����
		 */
		Set unmodifiableSet=Collections.singleton("�������");
		/*
		 * ����һ����ͨMap����
		 */
		Map<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("����" , 80);
		scores.put("Java" , 82);
		/*
		 * ����scores�Ĳ��ɱ�汾
		 */
		Map unmodifiableMap=Collections.unmodifiableMap(scores);
		
	}
}
