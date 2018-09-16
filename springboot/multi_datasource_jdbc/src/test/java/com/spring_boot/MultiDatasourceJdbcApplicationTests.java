package com.spring_boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MultiDatasourceJdbcApplication.class)
public class MultiDatasourceJdbcApplicationTests {

//	@Autowired
//	@Qualifier("mysqlJdbcTemplate")
	@Resource
	protected JdbcTemplate mysqlJdbcTemplate;

//    @Autowired
//    @Qualifier("oracleJdbcTemplate")
	@Resource
    protected JdbcTemplate oracleJdbcTemplate;

	@Resource
	protected  JdbcTemplate secondaryJdbcTemplate;

	@Test
	public void contextLoads() {

		int cityCount = mysqlJdbcTemplate.queryForObject("select count(*) from city",Integer.class);
		System.err.println("mysql查询数量： " + cityCount);

		int xxfpCount = oracleJdbcTemplate.queryForObject("select count(*) from ETL_TAB_CTRL",Integer.class);
		System.err.println("oracle查询数量： " + xxfpCount);

		int bgxdbCount = secondaryJdbcTemplate.queryForObject("select count(*) from ETL_TAB_CTRL",Integer.class);
		System.err.println("bgxdb查询数量：" + bgxdbCount);
	}

}
