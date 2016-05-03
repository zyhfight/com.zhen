/*
 * 更新文档
 */
package MongoDB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient=new MongoClient("localhost",27017);
		MongoDatabase mongoDatabase=mongoClient.getDatabase("runoob");
		System.out.println("Connect to database successfully");
		MongoCollection<Document>mongoCollection=mongoDatabase.getCollection("test");
		System.out.println("Collection is choosed");
		//更新文档
		mongoCollection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
		//检索文档
		FindIterable<Document> findIterable=mongoCollection.find();
		MongoCursor<Document>mongoCursor=findIterable.iterator();
		while(mongoCursor.hasNext())
		{
			System.out.println(mongoCursor.next());
		}
	}

}
