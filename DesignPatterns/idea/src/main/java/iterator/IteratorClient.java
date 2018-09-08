package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class IteratorClient {
    public static void main(String[] args) {
        List<String> produts = new ArrayList<>();
        produts.add("倚天剑");
        produts.add("屠龙刀");
        produts.add("葵花宝典");

        //创建聚合对象
        AbstractObjectList list = new ProductList(produts);
        //创建迭代器对象
        AbstractIterator iterator = list.createIterator();

        System.out.println("正向遍历：");
        while(!iterator.isLast()){
            System.out.println(iterator.getNextItem() + " , ");
            iterator.next();
        }

        System.out.println("--------------------------------------");

        System.out.println("逆向遍历： ");
        while(!iterator.isFirst()){
            System.out.println(iterator.getPreviousItem() + " , ");
            iterator.pervious();
        }
    }
}
