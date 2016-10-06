package DesignPatterns.DecoratorPattern;
/**
 * 具体装饰类
 * @author zhenyonghe
 *
 */
public class SparrowDecorator extends Decorator{
	public final int DISTANCE=50;
	public SparrowDecorator(Bird bird) {
		super(bird);
	}
	@Override
	public int fly() {
		int distance=0;
		distance=bird.fly()+eleFly();
		return distance;
	}
	private int eleFly(){
		return DISTANCE;
	}

}
