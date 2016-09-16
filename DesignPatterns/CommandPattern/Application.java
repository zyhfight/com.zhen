package DesignPatterns.CommandPattern;

public class Application {

	public static void main(String[] args) {
		//�������ִ����
		Receiver receiver=new CompanyArmy();
		//���������ָ�������ߣ��ڱ�˾���
		Command command=new ConcreteCommand(receiver);
		//����������
		Invoker invoker=new ArmySuperior();
		//�������
		invoker.setCommand(command);
		//�������������ִ������
		invoker.startExecuteCommand();
	}

}
