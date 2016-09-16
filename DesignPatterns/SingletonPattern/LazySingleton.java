/**
 * ����ʽ����ģʽ
 */
package DesignPatterns.SingletonPattern;
/**
 * ʱ�任�ռ䣬ÿ�λ�ȡʵ���������жϣ��˷��жϵ�ʱ�䣬��һֱ���˵��ã��򲻻ᴴ��ʵ������ʡ�ڴ�ռ�
 * ���̰߳�ȫ�����ܴ��ڴ������ʵ��������ɼ�synchronized�ؼ��֣������������Ľϴ�
 * @author zhen
 *
 */
public class LazySingleton {
	private LazySingleton(){}
	private static LazySingleton instance;
	public LazySingleton getInstance(){
		if(instance==null){
			instance=new LazySingleton();
		}
		return instance;
	}
}
