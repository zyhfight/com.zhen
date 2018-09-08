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
public class StrategyClient {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();//创建环境类
        double originalPrice = 60;

        movieTicket.setPrice(originalPrice);
        System.out.println("原始价为： " + originalPrice);
        System.out.println("--------------------------------------");

        Discount discount = new StudentDiscount();
        movieTicket.setDiscount(discount);//注入具体策略类（算法）

        double currentPrice = movieTicket.getPrice();
        System.out.println("折后价： " + currentPrice);
    }
}
