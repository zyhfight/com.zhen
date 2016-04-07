package service;

import java.util.List;

import ServiceInterface.userInterface;
import orm.JdbcGetConnection;

public class userFunction implements userInterface{

	@Override
	public boolean addUser(Object obj) {
		try
		{
			JdbcGetConnection.getConnection().executeUpdate(obj);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public List<Object> selectUser(String sql,Object obj) {	
		return JdbcGetConnection.getConnection().executeQuery(sql, obj);
	}

	@Override
	public boolean deleteUser(String str) {
		try
		{
			JdbcGetConnection.getConnection().executeUpdate(str);
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
