/*
 * 连接数据库，需指定数据库名称，若指定的数据库不存在，
 * mongo会自动创建数据库
 * 无密码验证登陆
 */
package MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC01 {
	public static void main(String[] args)
	{
		try{
			//连接mongodb服务
			MongoClient mongoClient=new MongoClient("localhost",27017);
			//连接到数据库
			MongoDatabase mongoDatabase=mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully!");
		}catch(Exception e){
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
		
	}

}
