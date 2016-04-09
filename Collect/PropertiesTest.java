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
		 * 向Properties中增加属性
		 */
		pros.setProperty("username", "zhangsan");
		pros.setProperty("password", "12345");
		/*
		 * 将Properties中的key-value对保存到a.ini文件中（输出到硬盘）;"comment line"为注释
		 */
		try {
			pros.store(new FileOutputStream("a.ini"), "comment line");
			Properties pros2=new Properties();
			pros2.setProperty("gender", "male");
			/*
			 * 将a.ini文件输入到Properties中（输入到缓存区）
			 */
			pros2.load(new FileInputStream("a.ini"));
			System.out.println(pros2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
