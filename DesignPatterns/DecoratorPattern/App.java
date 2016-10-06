package DesignPatterns.DecoratorPattern;
/**
 * Main������ʵ��������ֱ����150�ף�200��
 * @author zhenyonghe
 *
 */
public class App {
	public void needBird(Bird bird){
		int flyDistance=bird.fly();
		System.out.println("��ֻ���ܷ��У�"+flyDistance+"�ף�");
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
/*��װ���ߺ�װ����������Ϲ�ϵ��װ���ߣ�Decorator�����������ڳ��������Component������˾���װ��ֻ֪����Ҫװ�εĶ����ǳ��������ĳһ�������ʵ����������֪�����ĸ��������ࡣ

װ��ģʽ���㡰��-��ԭ�򡱣������޸ľ���������Ϳ������µ���Ը�����ľ���װ�Ρ�

��ʹ�ö������װ�������ξ��������ʵ����*/
