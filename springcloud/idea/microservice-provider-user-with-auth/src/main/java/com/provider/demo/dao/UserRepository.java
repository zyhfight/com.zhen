package com.provider.demo.dao;

import com.provider.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-8-29
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-8-29     zyh           v1.0.0               修改原因
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
