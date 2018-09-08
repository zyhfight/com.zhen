package decorator;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体装饰类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    void display(){
        this.setBlackBorder();
        super.display();
    }

    void setBlackBorder(){
        System.out.println("为构件增加黑色边框！");
    }
}
