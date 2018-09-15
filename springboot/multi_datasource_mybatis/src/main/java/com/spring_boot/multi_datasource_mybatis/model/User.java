package com.spring_boot.multi_datasource_mybatis.model;

/**
 * Copyright: Copyright (c) 2017
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: 80234697
 * @date: 2018-7-25
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-25     80234697           v1.0.0               修改原因
 */
public class User {
    private long count;
    private City city;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "count=" + count +
                ", city=" + city +
                '}';
    }
}
