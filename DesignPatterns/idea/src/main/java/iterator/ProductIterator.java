package iterator;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体迭代器
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class ProductIterator implements AbstractIterator{
    private ProductList productList;
    private List products;
    private int cursor1; //用于记录正向遍历的位置
    private int cursor2;//用于记录逆向遍历的位置

    public ProductIterator(ProductList list){
        this.productList = list;
        this.products = list.getObjects();
        cursor1 = 0;
        cursor2 = products.size() - 1;
    }

    @Override
    public void next() {
        if(cursor1 < products.size()){
            cursor1++;
        }
    }

    @Override
    public boolean isLast() {
        return cursor1 == products.size();
    }

    @Override
    public void pervious() {
        if(cursor2 > -1){
            cursor2--;
        }
    }

    @Override
    public boolean isFirst() {
        return cursor2 == -1;
    }

    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}
