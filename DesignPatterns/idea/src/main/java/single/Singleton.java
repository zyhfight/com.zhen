package single;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: Initialization on Demand Holder
 * 由于静态单例对象没有作为Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton；
 * 第一次调用getInstance()时将加载内部类HolderClass，在该内部类定义了一个static类型的变量instance；
 * 此时会首先初始化这个成员变量，由java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。
 * 由于getInstance()方法没有任何线程锁定，因此其性能不会造成任何影响；
 * 通过使用IODH，既可以实现延迟加载，又可以保证线程安全，不影响系统性能，集成了饿汉式和懒汉式单例模式优点。
 * （其缺点是与编程语言本身特性相关，很多面向对象语言不支持IODH，一种最好的java编程语言单例模式实现方式！）
 *
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-19     zyh           v1.0.0               修改原因
 */
public class Singleton {

    private Singleton(){}

    private static class HolderClass{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return HolderClass.instance;
    }
}
