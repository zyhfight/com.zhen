/*
 * hashMap����key��valueΪnull
 */
package Collect;

import java.util.HashMap;

public class NullInHashMap {
	public static void main(String[] args)
	{
		HashMap<String, Object> hm = new HashMap<String, Object>();
		/*
		 * ��keyΪnull��key-value�Է���HashMap��
		 */
		hm.put(null , null);
		/*
		 *  ��һ��valueΪnull��key-value�Է���HashMap��
		 */
		hm.put("a" , null); 
		// ���Map����
		System.out.println(hm);
	}
}
