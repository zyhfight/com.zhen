/*
 * ���л�����
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
		 * ʵ�廯Employee��
		 */
		Employee e=new Employee();
		e.name="Reyan Ali";
		e.address="Phokka kuan,Ambeht peer";
		e.SSN=11122333;
		e.number=110;
		/*
		 * �����л�һ�������ļ�ʱ�� ����Java�ı�׼Լ���Ǹ��ļ�һ��.ser��չ��
		 */
		try {
			FileOutputStream fileOut=new FileOutputStream("employee.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileOut);
			/*
			 * ObjectOutputStream�������л����󷽷���writeObject���л�һ�����󣬲��������͵������
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
