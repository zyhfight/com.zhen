package Collect;


import java.util.*;
/*
 * LinkedHashMap�����࣬�ڲ���������ʽά��mapԪ�ؼ���˳��
 */
public class LinkedHashMapTest
{
    public static void main(String[] args)
    {
        LinkedHashMap<String, Integer> scores = new LinkedHashMap<String, Integer>();
        scores.put("����", 80);
        scores.put("Ӣ��", 82);
        scores.put("��ѧ", 76);
        for (Object key : scores.keySet())
        {
            System.out.println(key + "-->" + scores.get(key));
        }
    }
}
