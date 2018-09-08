package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-9-8
 */

@Setter
@Getter
@ToString
public class User {
    private long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

}
