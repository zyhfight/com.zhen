package com.spring_boot.multi_datasource_mybatis.dao.oracle;

import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface EtlTabCtrlDao {

    int selectCount();
}
