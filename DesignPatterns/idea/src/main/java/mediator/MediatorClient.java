package mediator;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class MediatorClient {
    public static void main(String[] args) {
        //创建中介者
        ConcreteMediator meditor = new ConcreteMediator();

        //创建同事对象
        Button component1 = new Button();
        List component2 = new List();
        ComboBox component3 = new ComboBox();

        //维持同事对象与中介者的关联关系
        component1.setMeditor(meditor);
        component2.setMeditor(meditor);
        component3.setMeditor(meditor);

        //具体同事对象注入中介者
        meditor.addButton = component1;
        meditor.list = component2;
        meditor.comboBox = component3;

        component1.changed();

        System.out.println("--------------------------------------------------------");

        component2.changed();

        System.out.println("--------------------------------------------------------");

        component3.changed();

    }
}
