package service;

import java.util.List;

import ServiceInterface.questionnaireInterface;
import orm.JdbcGetConnection;
import po.questionnaire;

public class questionnaireFunction implements questionnaireInterface{

	@Override
	public boolean insertRecord(String sql) {
		// TODO Auto-generated method stub
		try
		{
			JdbcGetConnection.getConnection().executeUpdate(sql);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public List<Object> selectRecord(String sql) {
		// TODO Auto-generated method stub
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new questionnaire());
		return list;
	}
	public void deleteRecord(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}

}
