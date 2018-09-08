package command.window;

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
public class HelpCommand extends Command {

    private HelpHander helpHander;//具体命令类维持对请求接收者的引用

    public HelpCommand(){
        helpHander = new HelpHander();
    }

    //命令执行方法，调用请求者的业务方法
    @Override
    public void execute() {
        helpHander.display();;
    }
}
