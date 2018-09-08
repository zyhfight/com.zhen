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
public class MinimizeCommand extends Command {
    private WindowHandler windowHandler;
    public MinimizeCommand(){
        windowHandler = new WindowHandler();
    }
    @Override
    public void execute() {
        windowHandler.display();
    }
}
