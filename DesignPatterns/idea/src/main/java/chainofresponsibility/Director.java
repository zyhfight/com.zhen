package chainofresponsibility;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体处理者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class Director extends Approver{

    public Director(String name){
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        //处理请求
        if(request.getAmount() < 50000){
            System.out.println("主任： " + this.name + " 审批采购单： " + request);
        }else {
            this.successor.processRequest(request);//转发请求
        }
    }
}
