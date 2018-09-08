package observer;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体观察类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class Player implements Observer{
    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("坚持住，" + this.name + "来救你！");
    }

    @Override
    public void beAttacked(AllyControlCenter allyControlCenter) {
        System.out.println(this.name + "被攻击！");
        allyControlCenter.notifyObserver(name);

    }
}
