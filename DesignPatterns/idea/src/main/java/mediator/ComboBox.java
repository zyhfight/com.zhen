package mediator;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体同事类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class ComboBox extends Component {
    @Override
    public void update() {
        System.out.println("组合框增加一项：郭靖");
    }

    public void select(){
        System.out.println("组合框选中项：杨过");
    }
}
