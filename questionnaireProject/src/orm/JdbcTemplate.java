package orm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Reflection.ORM;
import po.usr;


public class JdbcTemplate {
	private  Connection conn=null;
	private PreparedStatement pre=null;
	public void setConnection(Connection connection)
	{
		conn=connection;
	}
/*
 * PreparedStatement下查询
 * */
	public PreparedStatement executeQuery(String sql)
	{
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pre;
	}
	//有条件（自己指定sql语句）查询；返回的list集合存储查询结果(结果存为相应对象）
	public List<Object> executeQuery(String sql,Object obj)
	{
		ResultSet rs=null;
		Class<?> cobj=obj.getClass();
		List<Object> list=new ArrayList<Object>();
		ORM orm=new ORM();
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next())
			{
				list.add(orm.toObject(rs, cobj));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()==0)
			return null;
		return list;
	}
	//无条件(特定sql语句：全查）；返回的list集合存储查询结果
	public List<Object> executeQuryAll(Object obj)
	{
		ResultSet rs=null;
		Class<?> cobj=obj.getClass();
		List<Object> list=new ArrayList<Object>();
		ORM orm=new ORM();
		String sql=orm.toSelectSql(obj);
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next())
			{
				list.add(orm.toObject(rs, cobj));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()==0)
			return null;
		return list;
	}
	//获取自增字段数据
	public List<Integer> getAutoIncrement(String sql)
	{
		ResultSet rs=null;
		List<Integer> list=new ArrayList<Integer>();
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next())
			{
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()==0)
			return null;
		return list;
	}
	//注册验证
	public List<Object> registerCheck(Object obj)
	{
		ResultSet rs=null;
		Class<?> cobj=obj.getClass();
		List<Object> list=new ArrayList<Object>();
		ORM orm=new ORM();
		String sql=orm.toRegisterCheckSql(obj);
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next())
			{
				list.add(orm.toObject(rs, cobj));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()==0)
			return null;
		return list;
	}
	//完善个人信息后，验证身份登陆
	public List<Object> identityCheck(String UsrID)
	{
		ResultSet rs=null;
		Class<?> cobj=new usr().getClass();
		List<Object> list=new ArrayList<Object>();
		ORM orm=new ORM();
		String sql=orm.toIdentitySql(UsrID);
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next())
			{
				list.add(orm.toObject(rs, cobj));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()==0)
			return null;
		return list;
	}
	//登陆验证
	public List<Object> loginCheck(Object obj)
	{
		ResultSet rs=null;
		Class<?> cobj=obj.getClass();
		List<Object> list=new ArrayList<Object>();
		ORM orm=new ORM();
		String sql=orm.toLoginCheckSql(obj);
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next())
			{
				list.add(orm.toObject(rs, cobj));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()==0)
			return null;
		return list;
	}
/*
 * PreparedStatement下更新
 */
	//有条件（自己指定sql语句）进行数据库表的Update
	public PreparedStatement executeUpdate(String sql)
	{
		if(conn==null)
		{
			return null;
		}
		try {
			pre=conn.prepareStatement(sql);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return pre;
	}
	//无条件（特定的插入sql语句）；将传入对象入库
	public PreparedStatement executeUpdate(Object obj)
	{
		if(conn==null)
		{
			return null;
		}
		ORM orm=new ORM();
		String sql=orm.toInsertSql(obj);
		try {
			pre=conn.prepareStatement(sql);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return pre;
	}
}

