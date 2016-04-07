package service;

import java.util.List;

import orm.JdbcGetConnection;
import po.myRestrict;

public class restrictFunction {
	public static boolean insertRecord(Object obj) {
		
		if(JdbcGetConnection.getConnection().executeUpdate(obj)==null)
			return false;
		return true;
	}

	
	public static List<Object> selectRecord(String sql) {
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new myRestrict());
		return list;
	}
	public static void deleteRecord(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}
}
