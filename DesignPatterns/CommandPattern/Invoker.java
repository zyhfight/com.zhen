package DesignPatterns.CommandPattern;
/**
 * 命令发布者（统一Invoker接口）
 * @author zhen
 *
 */
public interface Invoker {
	public void setCommand(Command command);
	public void startExecuteCommand();
}
