package iterator;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体聚合类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class ProductList extends AbstractObjectList{

    public ProductList(List products){
        super(products);
    }
    //创建迭代器对象的具体工厂方法
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
