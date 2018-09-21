package com.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.demo.domain.City;
import com.springboot.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : zyh
 * @date : 2018-09-16 下午2:47
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 插入 ES 新城市
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public Long createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    /**
     * AND 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    @RequestMapping(value = "/api/city/and/find", method = RequestMethod.GET)
    public List<City> findByDescriptionAndScore(@RequestParam(value = "description") String description,
                                                @RequestParam(value = "score") Integer score) {
        return cityService.findByDescriptionAndScore(description, score);
    }

    /**
     * OR 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    @RequestMapping(value = "/api/city/or/find", method = RequestMethod.GET)
    public List<City> findByDescriptionOrScore(@RequestParam(value = "description") String description,
                                               @RequestParam(value = "score") Integer score) {
        return cityService.findByDescriptionOrScore(description, score);
    }

    /**
     * 查询城市描述
     *
     * @param description
     * @return
     */
    @RequestMapping(value = "/api/city/description/find", method = RequestMethod.GET)
    public List<City> findByDescription(@RequestParam(value = "description") String description) {
        return cityService.findByDescription(description);
    }

    /**
     * NOT 语句查询
     *
     * @param description
     * @return
     */
    @RequestMapping(value = "/api/city/description/not/find", method = RequestMethod.GET)
    public List<City> findByDescriptionNot(@RequestParam(value = "description") String description) {
        return cityService.findByDescriptionNot(description);
    }

    /**
     * LIKE 语句查询
     *
     * @param description
     * @return
     */
    @RequestMapping(value = "/api/city/like/find", method = RequestMethod.GET)
    public List<City> findByDescriptionLike(@RequestParam(value = "description") String description) {
        return cityService.findByDescriptionLike(description);
    }

    public static void main(String[] args) {
        City city = new City();
        city.setId(1L);
        city.setDescription("description");
        city.setName("杭州");
        city.setScore(1);

        System.out.println(JSON.toJSON(city));
    }

}
