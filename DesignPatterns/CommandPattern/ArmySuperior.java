package DesignPatterns.CommandPattern;
/**
 * 命令发布者
 * @author zhen
 *
 */
public class ArmySuperior implements Invoker{
	private Command command;
	//拟草命令
	public void setCommand(Command command){
		System.out.println("命令拟草成功！");
		this.command=command;
	}
	//发布命令，让接收者执行
	public void startExecuteCommand(){
		System.out.println("命令发布，收到请立刻执行！");
		command.execute();
	}
}
