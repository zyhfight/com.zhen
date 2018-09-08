package flyweight;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象享元类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public abstract class IgoChessman {
    public abstract String getColor();
    public void display(Coordinates coordinates){
        System.out.println("棋子颜色： " + this.getColor() + " 棋子位置：" + coordinates);
    }
}
