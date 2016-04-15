/*
 * �����л�����
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
			 * employee.ser�洢��Employee���л�������Ϣ
			 */
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in=new ObjectInputStream(fileIn);
			/*
			 * �����ж������󣬲����������л�������Object����ǿת�������͡�
			 */
			e=(Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * ��ӡ������Ϣ��
		 */
		System.out.println("Deserialized Employee...");
		System.out.println("Name:"+e.name);
		System.out.println("Address:"+e.address);
		System.out.println("SSn:"+e.SSN);
		System.out.println("Number:"+e.number);
	}
}
