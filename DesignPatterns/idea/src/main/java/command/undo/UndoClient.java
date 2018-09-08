package command.undo;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-21     zyh           v1.0.0               修改原因
 */
public class UndoClient {
    public static void main(String[] args) {
        //创建请求发送方；发送方类中维持了与命令类关联关系
        CalculatorForm form = new CalculatorForm();

        //创建命令；具体命令类中维持了与请求接收方关联关系
        Command command = new ConcreteCommand();

        //向发送者类中注入具体命令类
        form.setCommand(command);

        form.compute(10);
        form.compute(5);
        form.undo();

    }
}
