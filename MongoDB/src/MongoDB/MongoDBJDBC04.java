/*
 * 获取集合
 */
package MongoDB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//连接mongodb服务
			MongoClient mongoClient=new MongoClient("localhost",27017);
			//连接数据库
			MongoDatabase mongoDatabase=mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully!");
			//获取集合
			MongoCollection<Document> collection=mongoDatabase.getCollection("test");
			System.out.println("Collection test is choosed");
		}catch(Exception e)
		{
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
	}

}
