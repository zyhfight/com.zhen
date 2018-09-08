package prototype;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 原型模式
 * 将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝自己来实现创建过程。
 * 通过克隆方法所创建的对象是全新的对象，它们在内存中拥有新的地址，通常对克隆所产生的对象进行修改不会对原型对象造成任何影响，
 * 每一个克隆对象都是相互独立的。
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class WeekLog implements Cloneable {

    private static final Logger logger = LoggerFactory.getLogger(WeekLog.class);

    private String name;
    private String date;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeekLog clone(){
        Object obj;
        try {
            obj = super.clone();
            return (WeekLog) obj;
        } catch (CloneNotSupportedException e) {
            logger.error("clone Exception： {}", ExceptionUtils.getStackTrace(e));
            return null;
        }

    }

    @Override
    public String toString() {
        return "WeekLog{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
