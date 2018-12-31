/**
 * 静态内部类
 */
package DesignPatterns.SingletonPattern;
/**
 * 外部类加载了，实例不一定被初始化，只有调用getInstance方法时，才会显式加载内部类，从而创建实例
 * 当创建实例很耗资源时，可以实现延迟加载,线程安全
 * @author zhen
 *
 * java编程语言特性，很多其他面向对象编程语言不支持；
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
