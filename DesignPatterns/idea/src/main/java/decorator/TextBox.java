package decorator;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体构件类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class TextBox extends Component{
    @Override
    void display() {
        System.out.println("显示文本框");
    }
}
