/*
 * ��������
 */
package MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//����mongodb����
			MongoClient mongoCLient=new MongoClient("localhost",27017);
			//���ӵ����ݿ�
			MongoDatabase mongoDatabase=mongoCLient.getDatabase("runoob");
			System.out.println("Connect to database sucessfully!");
			mongoDatabase.createCollection("test");
			System.out.println("Collection is created");
		//	mongoCLient.close();
		}catch(Exception e){
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
		
	}

}
