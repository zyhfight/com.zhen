package DesignPatterns.StrategyPattern;
/**
 * 策略模式（政策）：定义一系列算法，一个个封装起来，并且使他们可以相互替换。
 * 本模式使得算法可独立于使用它的客户而变化。
 * @author zhenyonghe
 *
 */
//接口封装的算法标识，抽象策略
public interface ComputableStrategy {
	public double computeScore(double[] a);
}
