package chainofresponsibility;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class MainClass {

    public static void main(String[] args) {
        Approver zhang = new Director("张无忌");
        Approver guo = new President("郭靖");

        //创建职责链
        zhang.setSuccessor(guo);

        PurchaseRequest pr1 = new PurchaseRequest(50001,"购买倚天剑");

        zhang.processRequest(pr1);
    }
}
