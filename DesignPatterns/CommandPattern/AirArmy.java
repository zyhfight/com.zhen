package DesignPatterns.CommandPattern;

public class AirArmy implements Receiver {

	@Override
	public void sneakAttack() {
		System.out.println("空军司令部收到命令，我部立刻发动空袭！");
	}

}
