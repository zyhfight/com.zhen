package DesignPatterns.CommandPattern;
/**
 * �������
 * @author zhen
 *
 */
public class ArmySuperior implements Invoker{
	private Command command;
	//�������
	public void setCommand(Command command){
		System.out.println("������ݳɹ���");
		this.command=command;
	}
	//��������ý�����ִ��
	public void startExecuteCommand(){
		System.out.println("��������յ�������ִ�У�");
		command.execute();
	}
}
