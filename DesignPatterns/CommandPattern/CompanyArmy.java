package DesignPatterns.CommandPattern;
/**
 * 具体执行命令类
 * @author zhen
 *
 */
public class CompanyArmy implements Receiver {

	@Override
	public void sneakAttack() {
		System.out.println("炮兵司令部收到命令,我部立刻发动攻击！");
	}

}
