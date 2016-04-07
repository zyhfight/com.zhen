package Reflection;

import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ORM {
	//传入一个对象，即可自动生成insert语句(成员属性全为String)。
	public String toInsertSql(Object obj) {
		StringBuffer bsql=null;
		Class<?> cobj=obj.getClass();
//		System.out.println("获取传入对象的类名"+cobj.getSimpleName());
		//导入java.lang.reflect包，获取该类的所有属性
		Field[] fs=cobj.getDeclaredFields();
		String tableName=cobj.getSimpleName();
		try {
			bsql=new StringBuffer("INSERT INTO ");
			bsql.append(tableName).append("(");
			int i;
			for(i=0;i<fs.length-1;i++)
			{
				fs[i].setAccessible(true);
				bsql.append(fs[i].getName()).append(",");
			}
			bsql.append(fs[i].getName()).append(")VALUES('");
//			try {放在此处，最后一句return null会提示dead code  为什么？？
			for(i=0;i<fs.length-1;i++)
			{
				fs[i].setAccessible(true);
				bsql.append(fs[i].get(obj)).append("','");
			}
			fs[i].setAccessible(true);
			bsql.append(fs[i].get(obj)).append("')");
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("根据对象obj获取插入语句："+bsql);
		if(bsql!=null)
			return bsql.toString();
		return null;	
	}
	//传入对象，生成查询sql语句
	public String toSelectSql(Object obj)
	{
		Class<?> cobj=obj.getClass();
		String tableName=cobj.getSimpleName();
		StringBuffer bsql=null;
		try{
			bsql=new StringBuffer("SELECT * FROM ");
			bsql.append(tableName);
//			System.out.println(bsql.toString());
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		//System.out.println(bsql.toString());放到此处，最后一句return null为dead code 为什么？？
		if(bsql!=null)
			return bsql.toString();
		return null;
	}
	//将数据库记录转为相应对象
	public Object toObject(ResultSet res, Class<?> cobj) {
		Object obj=null;
		try {
			obj=cobj.newInstance();
//			System.out.println("数据库记录转化为对应类："+obj.toString());
			Field[] fs=cobj.getDeclaredFields();
			for(Field field:fs)
			{
				field.setAccessible(true);
				//field.getName()是否需要转化为field.getName().toString()?
				field.set(obj, res.getString(field.getName().toString()));
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	//生成注册用户名验证sql语句
	public String toRegisterCheckSql(Object obj)
	{	
		StringBuffer bsql=null;
		try {
			bsql=new StringBuffer("SELECT * FROM USR WHERE USRID=");
			Class<?> cobj=obj.getClass();
			Field[] fs=cobj.getDeclaredFields();
			bsql.append("'");
			fs[0].setAccessible(true);
			bsql.append(fs[0].get(obj)).append("'");
//			System.out.println(bsql.toString());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bsql!=null)
			return bsql.toString();
		return null;
	}
	//完善个人信息后，根据用户名验证身份sql语句
	public String toIdentitySql(String UsrID)
	{
		StringBuffer bsql=null;
		bsql=new StringBuffer("SELECT * FROM USR WHERE USRID=");
		bsql.append("'").append(UsrID).append("'");
//		System.out.println(bsql.toString());
		return bsql.toString();
	}
	
	//生成登陆验证sql语句 
	public String toLoginCheckSql(Object obj)
	{
		StringBuffer bsql=null;
		try {
			bsql=new StringBuffer("SELECT * FROM USR WHERE USRID=");
			Class<?> cobj=obj.getClass();
			Field[] fs=cobj.getDeclaredFields();
			bsql.append("'");
			fs[0].setAccessible(true);
			bsql.append(fs[0].get(obj)).append("' AND PWD='");
			fs[1].setAccessible(true);
			bsql.append(fs[1].get(obj)).append("'");
//			System.out.println(bsql.toString());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bsql!=null)
			return bsql.toString();
		return null;
	}
}
