package DesignPatterns.StrategyPattern;
/**
 * ����ģʽ�����ߣ�������һϵ���㷨��һ������װ����������ʹ���ǿ����໥�滻��
 * ��ģʽʹ���㷨�ɶ�����ʹ�����Ŀͻ����仯��
 * @author zhenyonghe
 *
 */
//�ӿڷ�װ���㷨��ʶ���������
public interface ComputableStrategy {
	public double computeScore(double[] a);
}
