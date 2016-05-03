/*
 * �����ĵ�
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
			// ����mongodb����
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// ���ӵ����ݿ�
			MongoDatabase mongoDatabase = mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully");
			// ��ȡ����
			MongoCollection<Document> collection = mongoDatabase.getCollection("test");
			System.out.println("Collection is choosed");
			//�����ĵ�
			/**
			 * 1.�����ĵ�Document��������key-value��ʽ
			 * 2.�����ĵ�����List<Document>
			 * 3.���ĵ����ϲ������ݿ⼯��MongoCollection.insertMany(List<Document>);
			 * ���뵥���ĵ�MongoCollection.insertOne(Document);
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
