package state.account;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class AccountClient {
    public static void main(String[] args) {
        Account account = new Account("段誉",0);
        account.deposit(1000);
        account.withdraw(2000);
        account.deposit(3000);
        account.withdraw(4000);
        account.withdraw(1000);
        account.computeInterest();
    }
}
