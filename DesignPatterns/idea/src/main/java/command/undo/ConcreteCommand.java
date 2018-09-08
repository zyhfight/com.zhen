package command.undo;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体命令类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-21     zyh           v1.0.0               修改原因
 */
public class ConcreteCommand extends Command {
    private Adder adder = new Adder();//维持与接收方关联关系
    private int value;

    @Override
    public int excute(int value) {
        this.value = value;
        return adder.add(value);
    }

    @Override
    public int undo() {
        return adder.add(-value);
    }
}
