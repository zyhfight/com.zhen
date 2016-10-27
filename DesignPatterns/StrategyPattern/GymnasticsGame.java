package DesignPatterns.StrategyPattern;
/**
 * 上下文：可接收不同具体策略
 * @author zhenyonghe
 *
 */
public class GymnasticsGame {
	ComputableStrategy strategy;
	public void setStrategy(ComputableStrategy strategy){
		this.strategy=strategy;
	}
	public double getPersonScore(double[] a){
		if(strategy!=null){
			return strategy.computeScore(a);
		}else{
			return 0;
		}
	}
}
/*
上下文（Context）和具体策略（ConcreteStrategy）是松耦合关系。因此上下文只知道它要使用某一个实现Strategy接口类的实例，而不需知道具体是哪一个类。

策略模式满足“开-闭原则”。当增加新的具体策略时，不需要修改上下文类的代码，上下文就可引用新的具体策略的实例。
*/