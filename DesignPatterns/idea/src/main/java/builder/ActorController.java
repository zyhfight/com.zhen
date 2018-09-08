package builder;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 指挥者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class ActorController {

    public Actor construct(ActorBuilder ab){
       ab.buildType();
       ab.buildHairStyle();

       return ab.createActor();
    }
}
