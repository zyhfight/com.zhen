package observer;

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
public class ObserverClient {
    public static void main(String[] args) {
        //创建注册中心
        AllyControlCenter allyControlCenter = new ConcreteAllyControlCenter("金庸群侠");
        //创建观察者
        Observer observer1 = new Player();
        observer1.setName("张无忌");
        Observer observer2 = new Player();
        observer2.setName("令狐冲");
        Observer observer3 = new Player();
        observer3.setName("杨过");
        //将观察者添加进注册中心；在注册中心的成员发布消息，其他成员都能接收到
        allyControlCenter.join(observer1);
        allyControlCenter.join(observer2);
        allyControlCenter.join(observer3);

        //观察者1在注册中心发布消息
        observer1.beAttacked(allyControlCenter);

    }
}
