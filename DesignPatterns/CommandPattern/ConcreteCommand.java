package DesignPatterns.CommandPattern;
import DesignPatterns.CommandPattern.Receiver;
/**
 * 具体命令（多个命令则实现多个具体命令，统一Command命令接口）
 * @author zhen
 *
 */
public class ConcreteCommand implements Command {
	//具体命令需要指定命令接收者（炮兵司令部）
	private Receiver receiver;
	//命令接受者
	public ConcreteCommand(Receiver receiver) {
		this.receiver=receiver;
	}
	@Override
	public void execute() {
		//接收者执行命令
		receiver.sneakAttack();
	}

}
