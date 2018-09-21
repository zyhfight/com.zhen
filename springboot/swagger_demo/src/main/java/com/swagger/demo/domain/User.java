package com.swagger.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-9-21
 */
@Setter
@Getter
@ToString
public class User {
    private Long id;
    private String name;
    private Integer age;
}
