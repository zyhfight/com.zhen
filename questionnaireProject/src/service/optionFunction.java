package service;

import java.util.List;

import ServiceInterface.questionnaireInterface;
import orm.JdbcGetConnection;
import po.myOption;

public class optionFunction implements questionnaireInterface{

	@Override
	public boolean insertRecord(String sql) {
		
		if(JdbcGetConnection.getConnection().executeUpdate(sql)==null)
			return false;
		return true;
	}

	@Override
	public List<Object> selectRecord(String sql) {
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new myOption());
		return list;
	}
	public void deleteRecord(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}

}
