package mediator;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象同事类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public abstract class Component {
    protected Meditor meditor;

    public void setMeditor(Meditor meditor) {
        this.meditor = meditor;
    }

    public void changed(){
        meditor.componentChanged(this);
    }

    public abstract void update();
}
