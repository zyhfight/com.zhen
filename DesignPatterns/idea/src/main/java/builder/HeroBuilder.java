package builder;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体建造者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class HeroBuilder  extends ActorBuilder{
    @Override
    void buildType() {
        actor.setType("英雄");
    }

    @Override
    void buildHairStyle() {
        actor.setHairstyle("飘逸");
    }
}
