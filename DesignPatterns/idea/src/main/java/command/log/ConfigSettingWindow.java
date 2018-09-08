package command.log;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 请求发送者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class ConfigSettingWindow {
    private List<Command> commands = new ArrayList<>();
    private Command command;
    //注入具体命令对象
    public void setCommand(Command command){
        this.command = command;
    }

    public void call(String args){
        command.execute(args);
        commands.add(command);
    }

    //记录请求日志，生成日志文件，将命令集合写入日志文件
    public void  save(){
        FileUtil.writeCommands(commands);
    }

    public void recover(){
        List<Command> list = FileUtil.readCommands();
        for(Command command : list){
            command.execute();
        }
    }
}
