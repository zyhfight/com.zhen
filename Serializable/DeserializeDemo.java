/*
 * 反序列化对象
 */
package Serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
	public static void main(String[] args)
	{
		Employee e=null;
		try {
			/*
			 * employee.ser存储了Employee序列化对象信息
			 */
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in=new ObjectInputStream(fileIn);
			/*
			 * 从流中读出对象，并将对象反序列化，返回Object，需强转数据类型。
			 */
			e=(Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * 打印对象信息。
		 */
		System.out.println("Deserialized Employee...");
		System.out.println("Name:"+e.name);
		System.out.println("Address:"+e.address);
		System.out.println("SSn:"+e.SSN);
		System.out.println("Number:"+e.number);
	}
}
