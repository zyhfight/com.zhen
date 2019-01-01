package com.kafka.simple.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2019-1-1
 */
@Data
@AllArgsConstructor
public class Response {
    private int code;
    private String msg;
}
