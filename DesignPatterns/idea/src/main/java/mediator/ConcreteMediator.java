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
public class ConcreteMediator extends Meditor {

    //维持对各个同事对象的引用
    public Button addButton;
    public List list;
    public ComboBox comboBox;

    @Override
    public void componentChanged(Component component) {
        if(component == addButton){
            System.out.println("--单击增加按钮--");
            list.update();
            comboBox.update();;
        }
        if(component == list){
            System.out.println("--从列表框选择客户--");
            list.select();
        }
        if(component == comboBox){
            System.out.println("--从组合框选中客户--");
            comboBox.select();
        }
    }
}
