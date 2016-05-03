/*
 * 删除文档
 */
package MongoDB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient=new MongoClient("localhost",27017);
		MongoDatabase mongoDatabase=mongoClient.getDatabase("runoob");
		System.out.println("Connect to database successfully");
		MongoCollection<Document>mongoCollection=mongoDatabase.getCollection("test");
		System.out.println("Collection is choosed");
		//删除符合条件的第一个文档
		mongoCollection.deleteOne(Filters.eq("likes", 200));
		//删除符合条件的所有文档
		mongoCollection.deleteMany(Filters.eq("likes", 200));
		//检索文档
		FindIterable<Document> findIterable=mongoCollection.find();
		MongoCursor<Document>mongoCursor=findIterable.iterator();
		while(mongoCursor.hasNext())
		{
			System.out.println(mongoCursor.next());
		}		
	}

}
