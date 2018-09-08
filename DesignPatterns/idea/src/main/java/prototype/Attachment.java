package prototype;

import java.io.Serializable;

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
public class Attachment  implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download(){
        System.out.println("下载附件，文件名为：" + name);
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "name='" + name + '\'' +
                '}';
    }
}
