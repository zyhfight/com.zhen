package command.window;

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
public class WindowClient {

    public static void main(String[] args) {
        //创建请求发送方
        FBSettingWindow fbsw = new FBSettingWindow("功能键设置");
        FunctionButton fb1 = new FunctionButton("功能键1");
        FunctionButton fb2 = new FunctionButton("功能键1");

        //创建命令；具体命令类中维持了命令与请求接收方关联关系
        Command command1 = new HelpCommand();
        Command command2 = new MinimizeCommand();

        //维持发送方和命令间关联关系
        fb1.setCommand(command1);
        fb2.setCommand(command2);

        //功能键加入页面窗口，并展示
        fbsw.addFunctionButton(fb1);
        fbsw.addFunctionButton(fb2);
        fbsw.display();

        //发送请求，调用功能键业务方法
        fb1.onClick();
        fb2.onClick();

    }
}
