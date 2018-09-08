package single;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 懒汉式单例模式
 * 懒汉式单例类在第一次使用时创建，无需一直占有系统资源，实现类延迟加载，但是必须处理好多线程同时访问问题；
 * 特别当单例类作为资源控制器，在实例化时必然涉及资源初始化，而资源初始化很可能消耗大量时间，
 * 这意味着出现多线程并发访问此类的机率变得较大，需要通过双重检查锁定等机制进行控制，这将导致系统性能受到一定影响。
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class LazySingleton {
    private volatile static LazySingleton lazySingleton = null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
