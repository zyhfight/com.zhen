package state.account;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 受限状态：具体状态类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class RestrictedState extends AccountState {

    public RestrictedState(Account account){
        this.account = account;
    }

    public RestrictedState(AccountState state){
        this.account = state.account;
    }

    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("账号受限，取款失败！");
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
        }else if(account.getBalance() > -2000){
            account.setAccountState(new OverdraftState(this));
        }
    }
}
