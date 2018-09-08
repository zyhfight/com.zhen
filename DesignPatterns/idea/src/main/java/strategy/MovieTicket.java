package strategy;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 环境类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class MovieTicket {
    private double price;
    private Discount discount;//维持环境类与抽象策略类间的关联关系

    public void setPrice(double price) {
        this.price = price;
    }

    //注入策略类
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        //调用折扣类的折扣价计算方法
        return discount.calculate(this.price);
    }


}
