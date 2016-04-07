package service;

import orm.JdbcGetConnection;
import po.usr;

public class ModifyPasswordFuntion {
		public static usr getUsr(String usrID)
		{
			String sql="SELECT * FROM Usr WHERE usrID='"+usrID+"'";
//			System.out.println("修改密码时查询语句"+sql);
			return (usr) JdbcGetConnection.getConnection().executeQuery(sql, new usr()).get(0);
		}
		public static void modifyPassword(String sql)
		{
			JdbcGetConnection.getConnection().executeUpdate(sql);
		}
	
}
