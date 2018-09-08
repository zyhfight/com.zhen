package command.undo;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 请求发送者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-21     zyh           v1.0.0               修改原因
 */
public class CalculatorForm {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void compute(int value){
        System.out.println("执行运算，运算结果为; " + command.excute(value));
    }

    public void undo(){
        System.out.println("执行撤销，运算结果为; " + command.undo());
    }
}
