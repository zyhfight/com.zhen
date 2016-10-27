package DesignPatterns.StrategyPattern;

public class App {
	public static void main(String[] args) {
		GymnasticsGame game = new GymnasticsGame();
		game.setStrategy(new StrategyOne());
		double[] a = { 9.12, 9.25, 8.87, 9.99, 6.99, 7.88 };
		double[] b = { 9.15, 9.26, 8.97, 9.89, 6.97, 7.89 };
		Person zhang=new Person();
		zhang.setName("����");
		Person li=new Person();
		li.setName("����");
		zhang.setScore(game.getPersonScore(a));
		li.setScore(game.getPersonScore(b));
		System.out.println("ʹ������ƽ��ֵ������");
		System.out.println(zhang.getName()+":"+zhang.getScore());
		System.out.println(li.getName()+":"+li.getScore());
		game.setStrategy(new StrategyTwo());
		zhang.setScore(game.getPersonScore(a));
		li.setScore(game.getPersonScore(b));
		System.out.println("ʹ�ü���ƽ��ֵ������");
		System.out.println(zhang.getName()+":"+zhang.getScore());
		System.out.println(li.getName()+":"+li.getScore());
		game.setStrategy(new StrategyThree());
		zhang.setScore(game.getPersonScore(a));
		li.setScore(game.getPersonScore(b));
		System.out.println("ʹ��(ȥ����ߡ���) ����ƽ��ֵ������");
		System.out.println(zhang.getName()+":"+zhang.getScore());
		System.out.println(li.getName()+":"+li.getScore());
	}
}
class Person{
	private String name;
	private double score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}