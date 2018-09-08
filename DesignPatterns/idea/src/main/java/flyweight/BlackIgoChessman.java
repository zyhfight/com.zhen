package flyweight;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体享元类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class BlackIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "黑色";
    }
}
