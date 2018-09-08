package chainofresponsibility;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体处理类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class President extends Approver {
    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount() >= 50000 ){
            System.out.println("董事长： " + this.name + " 审批采购单： " + request);
        }else{
            this.successor.processRequest(request);
        }
    }
}
