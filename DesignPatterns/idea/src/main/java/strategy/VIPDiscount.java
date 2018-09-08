package strategy;

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
public class VIPDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分:" + price);
        return price * 0.5;
    }
}
