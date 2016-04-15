/*
 * 序列化对象
 */
package Serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
	public static void main(String[] args) throws FileNotFoundException
	{
		/*
		 * 实体化Employee类
		 */
		Employee e=new Employee();
		e.name="Reyan Ali";
		e.address="Phokka kuan,Ambeht peer";
		e.SSN=11122333;
		e.number=110;
		/*
		 * 当序列化一个对象到文件时， 按照Java的标准约定是给文件一个.ser扩展名
		 */
		try {
			FileOutputStream fileOut=new FileOutputStream("employee.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileOut);
			/*
			 * ObjectOutputStream包含序列化对象方法；writeObject序列化一个对象，并将它发送到输出流
			 */
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in employee.ser");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
