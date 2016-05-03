/*
 * 插入文档
 */
package MongoDB;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 连接mongodb服务
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// 连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully");
			// 获取集合
			MongoCollection<Document> collection = mongoDatabase.getCollection("test");
			System.out.println("Collection is choosed");
			//插入文档
			/**
			 * 1.创建文档Document，参数：key-value格式
			 * 2.创建文档集合List<Document>
			 * 3.将文档集合插入数据库集合MongoCollection.insertMany(List<Document>);
			 * 插入单个文档MongoCollection.insertOne(Document);
			 */
			Document document = new Document("title", "MongoDB").append("description", "database").append("likes", 100)
					.append("by", "Fly");
			List<Document> documents = new ArrayList<Document>();
			documents.add(document);
			collection.insertMany(documents);
			System.out.println("Document is inserted");
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ":" + e.getMessage());
		}
	}

}
