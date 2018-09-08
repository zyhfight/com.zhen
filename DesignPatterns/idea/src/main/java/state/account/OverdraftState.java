package state.account;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 透支状态：具体状态类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class OverdraftState extends AccountState {

    public OverdraftState(Account account){
        this.account = account;
    }

    public OverdraftState(AccountState state){
        this.account = state.account;
    }

    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    //在具体状态类中进行状态变换
    @Override
    public void stateCheck() {
        if (account.getBalance() > 0){
            account.setAccountState(new NormalState(this));
        }else if(account.getBalance()==-2000){
            account.setAccountState(new RestrictedState(this));
        }else if(account.getBalance() < -2000){
            System.out.println("操作受限！");
        }
    }
}
