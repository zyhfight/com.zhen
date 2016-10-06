package DesignPatterns.DecoratorPattern;
/**
 * 具体组件
 * @author zhenyonghe
 *小鸟可以飞行100米
 */
public class Sparrow extends Bird{
	public final int DISTANCE=100;
	public int fly(){
		return DISTANCE;
	}
}
