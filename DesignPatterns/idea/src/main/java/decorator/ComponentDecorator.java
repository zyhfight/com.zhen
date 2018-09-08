package decorator;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象装饰类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class ComponentDecorator extends Component {
    private Component component;

    public ComponentDecorator(Component component){
        this.component = component;
    }

    @Override
    void display() {
        component.display();
    }
}
