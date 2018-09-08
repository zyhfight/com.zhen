package builder;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class MainClass {

    public static void main(String[] args) {
        ActorBuilder angelBuilder = new AngelBuilder();
        ActorBuilder heroBuilder = new HeroBuilder();

        ActorController ac = new ActorController();
        System.out.println(ac.construct(angelBuilder));
        System.out.println(ac.construct(heroBuilder));
    }
}
