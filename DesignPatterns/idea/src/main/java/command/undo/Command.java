package command.undo;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象命令类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-21     zyh           v1.0.0               修改原因
 */
public abstract  class Command {
    public abstract int excute(int value);//声明命令执行方法
    public abstract  int undo();//声明撤销方法
}
