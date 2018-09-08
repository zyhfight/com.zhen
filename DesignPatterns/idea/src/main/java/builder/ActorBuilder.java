package builder;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象建造者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    abstract void buildType();
    abstract  void buildHairStyle();

    public Actor createActor(){
        return actor;
    }

}
