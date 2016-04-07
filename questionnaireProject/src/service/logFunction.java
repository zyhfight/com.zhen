package service;

import java.util.List;

import orm.JdbcGetConnection;
import po.log;

public class logFunction {
	public static void insertLog(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}
	public static List<Object> selectRecord(String sql) {
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new log());
		return list;
	}
	public static void insertLog(Object obj)
	{
		JdbcGetConnection.getConnection().executeUpdate(obj);
	}
}
