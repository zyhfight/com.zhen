package DesignPatterns.StrategyPattern;
/**
 * �����ģ��ɽ��ղ�ͬ�������
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
�����ģ�Context���;�����ԣ�ConcreteStrategy��������Ϲ�ϵ�����������ֻ֪����Ҫʹ��ĳһ��ʵ��Strategy�ӿ����ʵ����������֪����������һ���ࡣ

����ģʽ���㡰��-��ԭ�򡱡��������µľ������ʱ������Ҫ�޸���������Ĵ��룬�����ľͿ������µľ�����Ե�ʵ����
*/