/**
 * ˫�ؼ���������ģʽ
 */
package DesignPatterns.SingletonPattern;
/**
 * ��һ�μ�鲻ͬ�������뷽�������ж�ʵ���Ƿ���ڣ��������ڲŽ�������ͬ�������
 * �ڶ��μ��ͬ��������ͬ���������ټ��ʵ���Ƿ���ڣ��������ڣ�����ͬ������´���ʵ��
 * ������ֻ��Ҫͬ��һ���ˣ���synchronizedͬ������������ߺܶ�
 * 
 * ����ʹ��volatile�ؼ��֣�
 * new DoubleCheckedSingleton()��ԭ�Ӳ���
 * ��������instance�����ڴ棻
 * 	        ���ù��캯����ʼ����Ա����
 *     ��instance����ָ�������ڴ�ռ䣨���ʵ��������
 * ����ʹ��volatile�ؼ��֣���֤�����ɼ������Ⲣ�����⡣
 * 
 * ĳЩƽ̨�ͱ��������ܲ�֧��
 */
public class DoubleCheckedSingleton {
	private DoubleCheckedSingleton(){}
	private volatile static DoubleCheckedSingleton instance;
	public static DoubleCheckedSingleton getInstance(){
		if(instance==null){
			synchronized (DoubleCheckedSingleton.class) {
				if(instance==null){
					instance=new DoubleCheckedSingleton();
				}
			}
		}
		return instance;
	}
}
