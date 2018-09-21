package com.springboot.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author : zyh
 * @date : 2018-09-15 下午9:54
 */
@Entity
@Setter
@Getter
public class Book {
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String writer;

    /**
     * 简介
     */
    private String introduction;
}
