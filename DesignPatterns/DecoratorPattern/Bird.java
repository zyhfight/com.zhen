package DesignPatterns.DecoratorPattern;
/**
 * װ��ģʽ����װ��������̬�ظ��������һЩ�����ְ��
 * ����̬��չһ������Ĺ��ܣ�������Ҫ�ı�ԭʼ����롣
 * �������������͡�����װ�Ρ����Ǹ�ģʽ����Ҫ��������ɫ
 * 
 * �������
 * @author zhenyonghe
 *
 *eg.����ϵͳ����һ��Bird�������Լ�Bird���һ�����ࣺSparrow��
 *Sparrow��ʵ����Bird���fly������ʹ��Sparrow�ഴ���Ķ���
 *����fly��������������100�ס������û���Ҫ�����񣬱���ֱ�
 *����������150�׺�200�ס�
 *
 */
public abstract class Bird {
	public abstract int fly();
}
