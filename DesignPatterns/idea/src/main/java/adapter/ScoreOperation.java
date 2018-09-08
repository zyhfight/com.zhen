package adapter;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 目标接口:面向抽象目标接口编程
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public interface ScoreOperation {

    int[] sort(int array[]);
    int search(int array[],int key);

}
