package flyweight;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class MainClass {

    public static void main(String[] args) {
        IgoChessman b1,b2,w1,w2;

        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();

        b1 = factory.getIgoChessman("b");
        b2 = factory.getIgoChessman("b");
        System.out.println(b1==b2);

        w1 = factory.getIgoChessman("w");
        w2 = factory.getIgoChessman("w");
        System.out.println(w1==w2);

        b1.display(new Coordinates(1,1));
        b2.display(new Coordinates(1,2));
        w1.display(new Coordinates(2,1));
        w1.display(new Coordinates(2,2));




    }
}
