<<<<<<< HEAD
package com.spring_boot.multi_datasource_mybatis.service.impl;

import com.spring_boot.multi_datasource_mybatis.dao.mysql.CityDao;
import com.spring_boot.multi_datasource_mybatis.dao.oracle.EtlTabCtrlDao;
import com.spring_boot.multi_datasource_mybatis.model.City;
import com.spring_boot.multi_datasource_mybatis.model.User;
import com.spring_boot.multi_datasource_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

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
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private EtlTabCtrlDao etlTabCtrlDao;


    @Override
    public User findUserByCityId(String id) {
        User user = new User();
        City city = cityDao.findById(id);
        int count = etlTabCtrlDao.selectCount();
        user.setCity(city);
        user.setCount(count);
        return user;
    }
}
=======
package com.spring_boot.multi_datasource_mybatis.service.impl;

import com.spring_boot.multi_datasource_mybatis.dao.mysql.CityDao;
import com.spring_boot.multi_datasource_mybatis.dao.oracle.EtlTabCtrlDao;
import com.spring_boot.multi_datasource_mybatis.model.City;
import com.spring_boot.multi_datasource_mybatis.model.User;
import com.spring_boot.multi_datasource_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

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
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private EtlTabCtrlDao etlTabCtrlDao;


    @Override
    public User findUserByCityId(String id) {
        User user = new User();
        City city = cityDao.findById(id);
        int count = etlTabCtrlDao.selectCount();
        user.setCity(city);
        user.setCount(count);
        return user;
    }
}
>>>>>>> e9c0499fbf2b802d8042d77019f8f202c2070c63
