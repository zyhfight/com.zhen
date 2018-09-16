package com.springboot.demo.service.impl;

import com.springboot.demo.dao.CityDao;
import com.springboot.demo.domain.City;
import com.springboot.demo.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author : zyh
 * @date : 2018-09-15 下午6:11
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public City findCityByName(String cityName) {
        String key = "city_" + cityName;
        ValueOperations<String,City> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            City city = operations.get(key);
            LOGGER.info("从redis获取city：{}", city);
            return city;
        }

        City city = cityDao.findByName(cityName);
        LOGGER.info("从db获取city：{}", city);

        //加入缓存
        operations.set(key,city,10, TimeUnit.MINUTES);

        return city;


    }
}
