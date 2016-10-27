package DesignPatterns.StrategyPattern;
//�������
public class StrategyOne implements ComputableStrategy{
	// ����ƽ����
	@Override
	public double computeScore(double[] a) {
		double score=0,sum=0;
		for(int i=0;i<a.length;++i){
			sum+=a[i];
		}
		score=sum/a.length;
		return score;
	}

}
