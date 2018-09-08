package state.account;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 银行账户：环境类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class Account {
    private AccountState accountState;//维持一个对抽象状态对象的引用
    private String owner;
    private double balance = 0;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.accountState = new NormalState(this);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public void deposit(double amount){
        System.out.println(this.owner + "存款：" + amount );
        accountState.deposit(amount);
        System.out.println("现在余额为：" + this.balance);
        System.out.println("现在账户状态为：" + this.accountState.getClass().getSimpleName());
        System.out.println("-----------------------------------------------------------------");
    }

    public void withdraw(double amount){
        System.out.println(this.owner + "取款：" + amount );
        accountState.withdraw(amount);
        System.out.println("现在余额为：" + this.balance);
        System.out.println("现在账户状态为：" + this.accountState.getClass().getSimpleName());
        System.out.println("-----------------------------------------------------------------");
    }

    public void computeInterest(){
        accountState.computeInterest();
    }



}
