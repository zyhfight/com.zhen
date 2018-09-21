package com.springboot.demo.dao;

import com.springboot.demo.domain.City;
import org.apache.ibatis.annotations.*;

/**
 * @author : zyh
 * @date : 2018-09-15 下午6:05
 */
@Mapper //非xml，标识为 Mybatis 的 Mapper
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
  //  City findByName(@Param("cityName") String cityName); //xml

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    @Select("SELECT * FROM city where city_name like concat('%', #{cityName}, '%')")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName") String cityName);

}
