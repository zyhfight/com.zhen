package service;

import java.util.List;

import orm.JdbcGetConnection;
import po.SELECTQUESTION;

public class selecQuestionFunction {
	public static List<Object> selectRecord(String sql) {
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new SELECTQUESTION());
		return list;
	}
	public static void deleteRecord(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}
}
