package service;


import java.util.List;

import orm.JdbcGetConnection;
import po.*;

public class selectRecord {
	public static List<Object> selectAnswerTable(String sql)
	{
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new answer());
		return list;
	}
	public static List<Object> selectQuetionnaireTable(String sql)
	{
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new questionnaire());
		return list;
	}
	/*public static List<Object> selectSymbolTable(String sql)
	{
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new symbol());
		return list;
	}*/
}
