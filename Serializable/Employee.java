/*һ����Ķ���Ҫ�����л��ɹ���������������������

�������ʵ�� java.io.Serializable ����

������������Ա����ǿ����л��ġ������һ�����Բ��ǿ����л��ģ�������Ա���ע���Ƕ��ݵġ�

�������֪��һ��Java��׼���Ƿ��ǿ����л��ģ���鿴������ĵ���

����һ�����ʵ���Ƿ������л�ʮ�ּ򵥣� 

ֻ��Ҫ�鿴������û��ʵ��java.io.Serializable�ӿڡ� */


/*
 * ��������л�ʵ����
 */
package Serializable;
//ʵ��java.io.Serializable�ӿ�
public class Employee implements java.io.Serializable{
	/**
	 * ÿ�����л����󶼻������ӦserialVersionUID�����л���ţ�
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String address;
	//ע��SSN����Ϊ���ݵģ��������л�
	public transient int SSN;
	public int number;
	public void mailCheck()
	{
		System.out.println("Mailing a check to "+ name +" "+address);
	}
}
