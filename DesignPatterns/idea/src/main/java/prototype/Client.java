package prototype;

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
public class Client {
    public static void main(String[] args){
        WeekLog log_previous = new WeekLog();
        log_previous.setName("张无忌");
        log_previous.setDate("第12周");
        log_previous.setContent("哈哈");

        System.out.println(log_previous);

        WeekLog log_new = log_previous.clone();
        log_new.setDate("第13周");

        System.out.println(log_new);

        System.out.println(log_previous == log_new);
        System.out.println(log_previous.getDate() == log_new.getDate());
        System.out.println(log_previous.getContent() == log_new.getContent());

    }
}

