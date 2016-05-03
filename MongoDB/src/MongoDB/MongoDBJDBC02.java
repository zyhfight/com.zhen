/*
 * ��֤�û���������
 */
package MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.*;
public class MongoDBJDBC02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//����MongoDB��������Զ�����ӿ����滻"localhost"Ϊ���������ڵ�IP��ַ
			//ServerAddress()������������������ַ���˿�
			ServerAddress serverAddress=new ServerAddress("localhost",27017);
			List<ServerAddress>addrs=new ArrayList<ServerAddress>();
			addrs.add(serverAddress);
			//mongoCredential.createScramSha1Credential()�����ֱ�Ϊ���û��������ݿ����ơ�����
			MongoCredential credential=MongoCredential.createScramSha1Credential("userName", "databaseName", "password".toCharArray());
			List<MongoCredential> credentials=new ArrayList<MongoCredential>();
			credentials.add(credential);
			//ͨ��������֤��ȡMongoDB����
			MongoClient mongoClient=new MongoClient(addrs,credentials);
			//���ӵ����ݿ�
			MongoDatabase mongoDatabase=mongoClient.getDatabase("databaseName");
			System.out.println("Connnect to database successfully");
		}catch(Exception e){
			System.err.println(e.getClass().getName()+":"+e.getMessage());
		}
		
		
	}

}
