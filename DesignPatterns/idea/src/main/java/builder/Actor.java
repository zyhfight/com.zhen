package builder;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 复杂对象
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class Actor {

    private String type;
    private String hairstyle;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "type='" + type + '\'' +
                ", hairstyle='" + hairstyle + '\'' +
                '}';
    }

    public String getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(String hairstyle) {
        this.hairstyle = hairstyle;
    }
}
