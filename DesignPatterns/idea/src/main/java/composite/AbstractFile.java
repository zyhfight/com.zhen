package composite;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象组件
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public abstract class AbstractFile {

    void add(AbstractFile file){
        System.out.println("对不起，不支持该方法！");
    }

    AbstractFile getChild(int i){
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    abstract void killVirus();
}
