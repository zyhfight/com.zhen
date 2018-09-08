package observer;


import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象注册中心
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public abstract class AllyControlCenter {
    protected String allyName;
    protected List<Observer> players = new ArrayList<>();//维持观察者引用List集合

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public String getAllyName() {
        return allyName;
    }

    //将观察者添加进注册中心
    public void join(Observer observer){
        System.out.println(observer.getName() + "加入" + this.allyName);
        players.add(observer);
    }

    //将观察者移除注册中心
    public  void quit(Observer observer){
        System.out.println(observer.getName() + "退出" + this.allyName);
        players.remove(observer);
    }

    //声明抽象通知方法
    public abstract void notifyObserver(String name);
}
