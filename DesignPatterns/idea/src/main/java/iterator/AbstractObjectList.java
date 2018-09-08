package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象聚合类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public abstract class AbstractObjectList {
    protected List<Object> objects = new ArrayList<>();

    public AbstractObjectList(List objects){
        this.objects = objects;
    }

    public void addObject(Object object){
        this.objects.add(object);
    }

    public void removeObject(Object object){
        this.objects.remove(object);
    }

    public List<Object> getObjects() {
        return objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();

}
