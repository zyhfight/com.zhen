<<<<<<< HEAD
package com.spring_boot.multi_datasource_mybatis.databaseConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Copyright: Copyright (c) 2017
 *
 * @Description: mysql数据源配置类
 * @version: v1.0.0
 * @author: 80234697
 * @date: 2018-7-25
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-25     80234697           v1.0.0               修改原因
 */
@Configuration
@MapperScan(basePackages = MysqlDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlDataSourceConfig {
    static final String PACKAGE = "com.spring_boot.multi_datasource_mybatis.dao.mysql";
    static final String MAPPER_LOCATION = "classpath:mapper/mysql/*.xml";

    @Value("${spring.datasource.mysql.url}")
    private String url;
    @Value("${spring.datasource.mysql.username}")
    private String user;
    @Value("${spring.datasource.mysql.password}")
    private String password;
    @Value("${spring.datasource.mysql.driver-class-name}")
    private String driverClass;

    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "mysqlTransactionManager")
    public DataSourceTransactionManager mysqlTransactionManager(){
        return new DataSourceTransactionManager(mysqlDataSource());
    }

    @Bean(name = "mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(mysqlDataSource());
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MysqlDataSourceConfig.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }
}
=======
package com.spring_boot.multi_datasource_mybatis.databaseConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Copyright: Copyright (c) 2017
 *
 * @Description: mysql数据源配置类
 * @version: v1.0.0
 * @author: 80234697
 * @date: 2018-7-25
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-25     80234697           v1.0.0               修改原因
 */
@Configuration
@MapperScan(basePackages = MysqlDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlDataSourceConfig {
    static final String PACKAGE = "com.spring_boot.multi_datasource_mybatis.dao.mysql";
    static final String MAPPER_LOCATION = "classpath:mapper/mysql/*.xml";

    @Value("${spring.datasource.mysql.url}")
    private String url;
    @Value("${spring.datasource.mysql.username}")
    private String user;
    @Value("${spring.datasource.mysql.password}")
    private String password;
    @Value("${spring.datasource.mysql.driver-class-name}")
    private String driverClass;

    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "mysqlTransactionManager")
    public DataSourceTransactionManager mysqlTransactionManager(){
        return new DataSourceTransactionManager(mysqlDataSource());
    }

    @Bean(name = "mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(mysqlDataSource());
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MysqlDataSourceConfig.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }
}
>>>>>>> e9c0499fbf2b802d8042d77019f8f202c2070c63
