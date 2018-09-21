package com.springboot.demo.service;

import com.springboot.demo.domain.City;

/**
 * @author : zyh
 * @date : 2018-09-15 下午6:09
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}
