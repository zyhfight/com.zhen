<<<<<<< HEAD
package com.spring_boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

/**
 * Copyright: Copyright (c) 2017
 *
 * @Description: 多数据源处理类
 * @version: v1.0.0
 * @author: 80234697
 * @date: 2018-7-24
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-24     80234697           v1.0.0               修改原因
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlDataSource")
//    @Qualifier("mysqlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleDataSource")
//    @Qualifier("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(DataSource dataSource){//@Qualifier("mysqlDataSource")可加可不加
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "oracleJdbcTemplate")
    public JdbcTemplate oracleJdbcTemplate(@Qualifier("oracleDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
=======
package com.spring_boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

/**
 * Copyright: Copyright (c) 2017
 *
 * @Description: 多数据源处理类
 * @version: v1.0.0
 * @author: 80234697
 * @date: 2018-7-24
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-24     80234697           v1.0.0               修改原因
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlDataSource")
//    @Qualifier("mysqlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleDataSource")
//    @Qualifier("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(DataSource dataSource){//@Qualifier("mysqlDataSource")可加可不加
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "oracleJdbcTemplate")
    public JdbcTemplate oracleJdbcTemplate(@Qualifier("oracleDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
>>>>>>> e9c0499fbf2b802d8042d77019f8f202c2070c63
