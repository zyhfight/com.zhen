/*
 * �������ݿ⣬��ָ�����ݿ����ƣ���ָ�������ݿⲻ���ڣ�
 * mongo���Զ��������ݿ�
 * ��������֤��½
 */
package MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC01 {
	public static void main(String[] args)
	{
		try{
			//����mongodb����
			MongoClient mongoClient=new MongoClient("localhost",27017);
			//���ӵ����ݿ�
			MongoDatabase mongoDatabase=mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully!");
		}catch(Exception e){
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
		
	}

}
