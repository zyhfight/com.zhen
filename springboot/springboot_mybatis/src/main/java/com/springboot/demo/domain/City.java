package com.springboot.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: com.springboot.demo.domain
 * @author : zyh
 * @date : 2018年09月15日 下午5:52
 */
@Setter
@Getter
@ToString
public class City implements Serializable {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;


}
