/*
 * ��ȡ����
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
			//����mongodb����
			MongoClient mongoClient=new MongoClient("localhost",27017);
			//�������ݿ�
			MongoDatabase mongoDatabase=mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully!");
			//��ȡ����
			MongoCollection<Document> collection=mongoDatabase.getCollection("test");
			System.out.println("Collection test is choosed");
		}catch(Exception e)
		{
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
	}

}
