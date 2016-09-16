/**
 * 懒汉式单例模式
 */
package DesignPatterns.SingletonPattern;
/**
 * 时间换空间，每次获取实例都进行判断，浪费判断的时间，若一直无人调用，则不会创建实例，节省内存空间
 * 非线程安全，可能存在创建多个实例情况（可加synchronized关键字，但是性能消耗较大）
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
