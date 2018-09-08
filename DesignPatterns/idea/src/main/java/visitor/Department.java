package visitor;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象访问者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public abstract class Department {
    //声明一组重载访问方法，用于访问不同类型的具体元素
    public abstract void visit(FulltimeEmployee employee);
    public abstract void visit(ParttimeEmployee employee);
}
