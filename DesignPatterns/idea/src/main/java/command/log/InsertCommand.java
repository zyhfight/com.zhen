package command.log;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体命令
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class InsertCommand extends  Command{

    public InsertCommand(String name){
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);
    }

    @Override
    public void execute() {
        configOperator.insert(this.args);
    }
}
