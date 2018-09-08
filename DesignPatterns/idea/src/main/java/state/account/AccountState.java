package state.account;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象状态类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public abstract class AccountState {
    protected Account account;//维持抽象状态类与环境类间的关联关系;protected包内可见
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void computeInterest();
    public abstract void stateCheck();
}
