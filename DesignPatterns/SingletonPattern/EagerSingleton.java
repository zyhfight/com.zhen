/**
 * 饿汉式单例模式
 */

package DesignPatterns.SingletonPattern;
/**
 * 空间换时间，当类加载时就会创建实例，每次调用时就无需再判断，节省了运行时间
 * 饿汉式是线程安全的，虚拟机保证只加载一次，在加载类时不会发生并发。
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
