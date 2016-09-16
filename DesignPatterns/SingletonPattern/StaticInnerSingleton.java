/**
 * ��̬�ڲ���
 */
package DesignPatterns.SingletonPattern;
/**
 * �ⲿ������ˣ�ʵ����һ������ʼ����ֻ�е���getInstance����ʱ���Ż���ʽ�����ڲ��࣬�Ӷ�����ʵ��
 * ������ʵ���ܺ���Դʱ������ʵ���ӳټ���,�̰߳�ȫ
 * @author zhen
 *
 */
public class StaticInnerSingleton {
	private static class InnerSingleton{
		private static final StaticInnerSingleton INSATNCE=new StaticInnerSingleton();
	}
	private StaticInnerSingleton(){}
	public static StaticInnerSingleton getInstance(){
		return InnerSingleton.INSATNCE;
	}
}
