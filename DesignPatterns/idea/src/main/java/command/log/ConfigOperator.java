package command.log;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 请求接收者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class ConfigOperator implements Serializable {
    public void insert(String args){
        System.out.println("增加新节点： " + args);
    }

    public void modify(String args){
        System.out.println("修改节点： " + args);
    }


}
