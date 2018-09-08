package observer;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体注册中心，负责发布具体消息
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class ConcreteAllyControlCenter extends  AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName){
        System.out.println(allyName + "战队组建成功！");
        System.out.println("---------------------------------------");
        this.allyName = allyName;
    }

    //实现通知方法，发布消息
    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName + "战队紧急通知，，盟友" + name +"需要支援");
        //遍历观察者集合，循环调用，通知（除自己外）盟友
        for(Observer observer : players){
            if(!observer.getName().equalsIgnoreCase(name)){
                observer.help();
            }

        }
    }
}
