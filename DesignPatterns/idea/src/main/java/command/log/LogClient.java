package command.log;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class LogClient {

    public static void main(String[] args) {
        ConfigSettingWindow csw = new ConfigSettingWindow();//请求发送者
        ConfigOperator co = new ConfigOperator();//请求接收者

        Command command = new InsertCommand("增加");//具体命令
        command.setConfigOperator(co);//维持命令与请求接收者的关联关系
        csw.setCommand(command);//维持请求发送者与命令的关联关系
        //call命令
        csw.call("网站首页");

        command = new ModifyCommand("修改");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("网站首页");

        System.out.println("------------------------------------------");

        System.out.println("保存设置");
        csw.save();

        System.out.println("------------------------------------------");
        System.out.println("恢复配置");
        System.out.println("------------------------------------------");
        csw.recover();


    }
}
