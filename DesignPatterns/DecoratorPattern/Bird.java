package DesignPatterns.DecoratorPattern;
/**
 * 装饰模式（包装器）：动态地给对象添加一些额外的职责。
 * 即动态扩展一个对象的功能，而不需要改变原始类代码。
 * “具体组件”类和“具体装饰”类是该模式最重要的两个角色
 * 
 * 抽象组件
 * @author zhenyonghe
 *
 *eg.假设系统中有一个Bird抽象类以及Bird类的一个子类：Sparrow。
 *Sparrow类实现了Bird类的fly方法，使得Sparrow类创建的对象
 *调用fly方法能连续飞行100米。现在用户需要两种鸟，必须分别
 *能连续飞行150米和200米。
 *
 */
public abstract class Bird {
	public abstract int fly();
}
