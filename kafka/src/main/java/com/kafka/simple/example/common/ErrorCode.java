package com.kafka.simple.example.common;

import lombok.Data;

/**
 * @Description: 错误返回码
 * @author: zyh
 * @date: 2019-1-1
 */
public enum ErrorCode {

    SUCCESS(200, "SUCCESS"),
    EXCEPTION(500,"EXCEPTION");

    private int code;
    private String desc;

    private ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
