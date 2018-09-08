package observer;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象观察类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public interface Observer {
    public String getName();
    public void setName(String name);
    public void help();
    public void beAttacked(AllyControlCenter allyControlCenter);

}
