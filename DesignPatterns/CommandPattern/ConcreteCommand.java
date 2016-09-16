package DesignPatterns.CommandPattern;
import DesignPatterns.CommandPattern.Receiver;
/**
 * ����������������ʵ�ֶ���������ͳһCommand����ӿڣ�
 * @author zhen
 *
 */
public class ConcreteCommand implements Command {
	//����������Ҫָ����������ߣ��ڱ�˾���
	private Receiver receiver;
	//���������
	public ConcreteCommand(Receiver receiver) {
		this.receiver=receiver;
	}
	@Override
	public void execute() {
		//������ִ������
		receiver.sneakAttack();
	}

}
