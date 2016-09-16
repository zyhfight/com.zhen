/**
 * 双重检查加锁单例模式
 */
package DesignPatterns.SingletonPattern;
/**
 * 第一次检查不同步，进入方法后，先判断实例是否存在，若不存在才进入下面同步代码块
 * 第二次检查同步，进入同步代码块后，再检查实例是否存在，若不存在，就在同步情况下创建实例
 * 这样就只需要同步一次了，比synchronized同步方法性能提高很多
 * 
 * 变量使用volatile关键字：
 * new DoubleCheckedSingleton()非原子操作
 * 包括：给instance分配内存；
 * 	        调用构造函数初始化成员变量
 *     将instance对象指向分配的内存空间（完成实例创建）
 * 所以使用volatile关键字，保证变量可见，避免并发问题。
 * 
 * 某些平台和编译器可能不支持
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
