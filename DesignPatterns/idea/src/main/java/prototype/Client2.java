package prototype;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;

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
public class Client2 {

    public static void main(String[] args) {
        WeekLog2 log_old, log_new = null;
        log_old = new WeekLog2();
        Attachment attachment = new Attachment();
        attachment.setName("测试");
        log_old.setAttachment(attachment);

        try {
            log_new = log_old.deepClone();
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
        System.out.println(log_old.getAttachment().getName() + " : " + log_new.getAttachment().getName());
        System.out.println(log_old.getAttachment() == log_new.getAttachment());
    }
}
