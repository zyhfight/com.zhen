package orm;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcGetConnection {
	private static Properties pro=new Properties();
	private static Connection conn=null;
	private static JdbcTemplate obj=null;
	public static JdbcTemplate getConnection()
	{
		if(obj==null)
		{
			obj=new JdbcTemplate();
			try {
				pro.load(new FileInputStream("jdbc.properties"));
				Class.forName(pro.getProperty("jdbc.driver"));
				conn=DriverManager.getConnection(pro.getProperty("jdbc.url"), 
						pro.getProperty("jdbc.usrName"), pro.getProperty("jdbc.passWd"));
			} catch (IOException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setConnection(conn);
		}
		return obj;		
	}

}
