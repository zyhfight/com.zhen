package decorator;

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
        Component component,componentSB;
        component = new Window();
        componentSB = new ScrollBarDecorator(component);
        componentSB.display();

        System.out.println("=========================================");

        Component component1,componentBB;
        component1 = new TextBox();
        componentSB = new ScrollBarDecorator(component1);
        componentBB = new BlackBorderDecorator(componentSB);
        componentBB.display();

    }
}
