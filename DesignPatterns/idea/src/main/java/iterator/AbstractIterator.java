package iterator;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象迭代器
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public interface AbstractIterator {
    void next();
    boolean isLast();
    void pervious();
    boolean isFirst();
    Object getNextItem();
    Object getPreviousItem();
}
