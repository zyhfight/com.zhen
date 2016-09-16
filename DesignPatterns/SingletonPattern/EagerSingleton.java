/**
 * ����ʽ����ģʽ
 */

package DesignPatterns.SingletonPattern;
/**
 * �ռ任ʱ�䣬�������ʱ�ͻᴴ��ʵ����ÿ�ε���ʱ���������жϣ���ʡ������ʱ��
 * ����ʽ���̰߳�ȫ�ģ��������ֻ֤����һ�Σ��ڼ�����ʱ���ᷢ��������
 * @author zhen
 *
 */
public class EagerSingleton {
	private EagerSingleton(){}
	private static EagerSingleton instance=new EagerSingleton();
	public static EagerSingleton getInstance(){
		return instance;
	}
}
