package state.switchshare;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class OffState extends State {
    @Override
    public void on(Switch s) {
        System.out.println("打开");
        s.setState(Switch.getState("on"));

    }

    @Override
    public void off(Switch s) {
        System.out.println("已经关闭！");
    }
}
