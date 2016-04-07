package service;

import java.util.List;

import ServiceInterface.questionnaireInterface;
import orm.JdbcGetConnection;
import po.answer;

public class answerFunction implements questionnaireInterface{

	@Override
	public boolean insertRecord(String sql) {
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
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new answer());
		return list;
	}

}
