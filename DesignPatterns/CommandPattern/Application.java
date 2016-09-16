package DesignPatterns.CommandPattern;

public class Application {

	public static void main(String[] args) {
		//命令接收执行者
		Receiver receiver=new CompanyArmy();
		//创建命令，并指定接收者（炮兵司令部）
		Command command=new ConcreteCommand(receiver);
		//创建发布者
		Invoker invoker=new ArmySuperior();
		//拟草命令
		invoker.setCommand(command);
		//发布命令，接收者执行命令
		invoker.startExecuteCommand();
	}

}
