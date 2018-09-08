package chainofresponsibility;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象处理类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public abstract class Approver {
    protected  Approver successor;//定义后继对象
    protected String name;

    public Approver (String name) {
        this.name = name;
    }

    //设置后继者
    public void setSuccessor(Approver successor){
        this.successor = successor;
    }

    //抽象请求处理方法
    public abstract void processRequest(PurchaseRequest request);


}

