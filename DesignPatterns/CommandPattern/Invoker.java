package DesignPatterns.CommandPattern;
/**
 * ������ߣ�ͳһInvoker�ӿڣ�
 * @author zhen
 *
 */
public interface Invoker {
	public void setCommand(Command command);
	public void startExecuteCommand();
}
