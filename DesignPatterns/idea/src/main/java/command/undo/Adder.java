package command.undo;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 请求接收者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-21     zyh           v1.0.0               修改原因
 */
public class Adder {
    private int num = 0;

    public int add(int value){
        num += value;
        return num;
    }
}
