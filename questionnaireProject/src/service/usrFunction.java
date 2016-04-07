package service;

import java.util.*;

import ServiceInterface.usrInterface;
import orm.JdbcGetConnection;
import po.usr;

public class usrFunction implements usrInterface{

	@Override
	public int checkIdentity(String sql) {
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new usr());
		if(list==null)
		{
			return -1;
		}
		usr usrObj=(usr)list.get(0);
		if(usrObj.getIdentity().equals("teacher"))
		{
			return 1;
		}
		if(usrObj.getIdentity().equals("student"))
		{
			return 2;
		}
		if(usrObj.getIdentity().equals("administrator"))
		{
			return 3;
		}
		return 0;
	}

	@Override
	public boolean addUsr(Object obj) {
		try
		{
			JdbcGetConnection.getConnection().executeUpdate(obj);
		}catch(Exception e){
			return false;
		}
		return true;
		
	}

	@Override
	public boolean deleteUsr(String str) {
		try
		{
			JdbcGetConnection.getConnection().executeUpdate(str);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public List<Object> selectUsr(String sql)
	{
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new usr());
		return list;
	}
	public static void updateUsr(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}

}
