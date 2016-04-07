package service;



import java.util.List;

import orm.JdbcGetConnection;
import po.student;
import po.teacher;

public class shareFunction {
	public static void insertInformation(Object obj)
	{
		JdbcGetConnection.getConnection().executeUpdate(obj);
	}
	public static void updateInformation(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}
	public static List<Object> selectTeacherInformation(String sql)
	{
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new teacher());
		return list;
	}
	public static List<Object> selectStudentInformation(String sql)
	{
		List<Object>list=JdbcGetConnection.getConnection().executeQuery(sql, new student());
		return list;
	}
	public static void insertInformation(String sql)
	{
		JdbcGetConnection.getConnection().executeUpdate(sql);
	}
}
