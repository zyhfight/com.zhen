/*
 * 检索所有文档
 */
package MongoDB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			MongoClient mongoClient=new MongoClient("localhost",27017);
			MongoDatabase mongoDatabase=mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully");
			MongoCollection<Document>mongoCollection=mongoDatabase.getCollection("test");
			System.out.println("Collection is choosed");
			//检索所有文档
			/**
			 * 1.获取迭代器FindIterable<Document>
			 * 2.获取游标MongoCursor<Document
			 * 2.通过游标检索出文档集合
			 */
			FindIterable<Document>findIterable=mongoCollection.find();
			MongoCursor<Document>mongoCursor=findIterable.iterator();
			while(mongoCursor.hasNext())
			{
				System.out.println(mongoCursor.next());
			}
		}catch(Exception e){
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
	}

}
