package strategy;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体策略类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class StudentDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}
