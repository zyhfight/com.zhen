package Collect;


import java.util.*;
/*
 * LinkedHashMap测试类，内部以链表形式维护map元素加入顺序
 */
public class LinkedHashMapTest
{
    public static void main(String[] args)
    {
        LinkedHashMap<String, Integer> scores = new LinkedHashMap<String, Integer>();
        scores.put("语文", 80);
        scores.put("英文", 82);
        scores.put("数学", 76);
        for (Object key : scores.keySet())
        {
            System.out.println(key + "-->" + scores.get(key));
        }
    }
}
