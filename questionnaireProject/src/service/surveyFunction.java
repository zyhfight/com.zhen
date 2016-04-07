package service;

import java.util.List;

import orm.JdbcGetConnection;
import po.survey;

public class surveyFunction {

	public static boolean insertRecord(Object obj) {
		try
		{
			JdbcGetConnection.getConnection().executeUpdate(obj);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	
	public static List<Object> selectRecord(String sql) {
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new survey());
		return list;
	}
	public static void deleteRecord(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}
}
