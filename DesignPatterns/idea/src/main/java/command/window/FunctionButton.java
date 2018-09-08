package command.window;

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
public class FunctionButton {
    private String name;
    private Command command; //维持一个抽象命令对象的引用

    public FunctionButton(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    //注入命令
    public void setCommand(Command command){
        this.command = command;
    }

    //通过抽象命令发送请求方法
    public void onClick(){
        System.out.println("点击功能键: ");
        command.execute();
    }
}
