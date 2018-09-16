package com.springboot.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author : zyh
 * @date : 2018-09-16 下午2:07
 */
@Document(indexName = "province", type = "city")
@Setter
@Getter
@ToString
public class City implements Serializable {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 城市评分
     */
    private Integer score;
}
