package single;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 饿汉式单例模式:当类被加载时，静态变量instance会被初始化，
 * 此时类的私有构造函数会被调用，单例类的唯一实例将被创建。
 * 饿汉式单例类在类加载时就实例化类，优点在于无需考虑多线程访问问题，可以确保实例的唯一性；
 * 从调用速度和反映时间角度来讲，由于单例对象一开始就得以创建，因此要由于懒汉式单例。
 * 但是无论系统在运行时是否需要使用该单例对象，由于在类加载时该对象就需要创建，
 * 因此从资源利用效率来讲，饿汉式单例不及懒汉式单例，而且在系统加载时由于需要创建饿汉式单例对象，加载时间可能会比较长。
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class EagerSingleton {

    private static final EagerSingleton  eagerSingleton = new EagerSingleton();

    private  EagerSingleton(){}

    public static  EagerSingleton getIntance(){
        return eagerSingleton;
    }
}
