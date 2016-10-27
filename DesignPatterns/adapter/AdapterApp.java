package designPattern.adapter;

public class AdapterApp {
	public static void main(String[] args) {
		ThreeElectricOutlet outlet;
		Wash wash=new Wash();
		outlet=wash;
		System.out.println("使用三相插座接通电流：");
		outlet.connectElectricCurrent();
		TV tv=new TV();
		//适配
		ThreeElectricAdapter adapter=new ThreeElectricAdapter(tv);
		outlet=adapter;
		System.out.println("使用三相插座接通电流：");
		outlet.connectElectricCurrent();
	}
}
//使用三相插座的洗衣机
class Wash implements ThreeElectricOutlet{
	private String name;
	public Wash() {
		name="黄河洗衣机";
	}
	public Wash(String s){
		name=s;
	}
	@Override
	public void connectElectricCurrent() {
		turnOn();
	}
	public void turnOn(){
		System.out.println(name+"开始洗衣物。");
	}
}
//使用两相插座的电视机
class TV implements TwoElectricOutlet{
	private String name;
	public TV(){
		name="长江电视机";
	}
	public TV(String s){
		name=s;
	}
	@Override
	public void connectElectricCurrent() {
		turnOn();
	}
	public void turnOn(){
		System.out.println(name+"开始播放节目。");
	}
}
/*
• 目标（Target）和被适配者（Adaptee）是完全解耦的关系。通过适配器联系，实现目标接口，包含被适配者实例引用。
• 适配器模式满足“开-闭原则”。当添加一个实现Adaptee接口的新类时，不必修改Adapter，
  Adapter就能对这个新类的实例进行适配
 
 
*/