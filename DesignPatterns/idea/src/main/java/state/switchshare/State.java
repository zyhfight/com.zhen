package state.switchshare;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象状态类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public abstract class State {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}
