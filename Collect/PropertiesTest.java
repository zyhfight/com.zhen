package Collect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args)
	{
		Properties pros=new Properties();
		/*
		 * ��Properties����������
		 */
		pros.setProperty("username", "zhangsan");
		pros.setProperty("password", "12345");
		/*
		 * ��Properties�е�key-value�Ա��浽a.ini�ļ��У������Ӳ�̣�;"comment line"Ϊע��
		 */
		try {
			pros.store(new FileOutputStream("a.ini"), "comment line");
			Properties pros2=new Properties();
			pros2.setProperty("gender", "male");
			/*
			 * ��a.ini�ļ����뵽Properties�У����뵽��������
			 */
			pros2.load(new FileInputStream("a.ini"));
			System.out.println(pros2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
