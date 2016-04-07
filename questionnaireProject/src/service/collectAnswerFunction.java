package service;

import java.util.List;

import orm.JdbcGetConnection;
import po.collectAnswer;

public class collectAnswerFunction {
	public static boolean insertRecord(String sql) {
		try
		{
			JdbcGetConnection.getConnection().executeUpdate(sql);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static List<Object> selectRecord(String sql) {
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new collectAnswer());
		return list;
	}

}
