package DesignPatterns.DecoratorPattern;
/**
 * Main方法：实现两种鸟分别飞行150米，200米
 * @author zhenyonghe
 *
 */
public class App {
	public void needBird(Bird bird){
		int flyDistance=bird.fly();
		System.out.println("这只鸟能飞行："+flyDistance+"米！");
	}
	public static void main(String[] args) {
		App client=new App();
		Bird sparrow=new Sparrow();
		Bird sparrowDecprator1=new SparrowDecorator(sparrow);
		Bird sparrowDecprator2=new SparrowDecorator(sparrowDecprator1);
		client.needBird(sparrowDecprator1);
		client.needBird(sparrowDecprator2);
		
	}

}
/*被装饰者和装饰者是松耦合关系，装饰者（Decorator）仅仅依赖于抽象组件（Component），因此具体装饰只知道它要装饰的对象是抽象组件的某一个子类的实例，但不需知道是哪个具体子类。

装饰模式满足“开-闭原则”，不必修改具体组件，就可增加新的针对该组件的具体装饰。

可使用多个具体装饰来修饰具体组件的实例。*/
