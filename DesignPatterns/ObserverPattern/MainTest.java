package DesignPatterns.ObserverPattern;

public class MainTest {

	public static void main(String[] args) {
		JobCenter jobCenter=new JobCenter();
		CurrentObserver currentObserver=new CurrentObserver();
		ExperiencedObserver experiencedObserver=new ExperiencedObserver();
		jobCenter.addObserver(currentObserver);
		jobCenter.addObserver(experiencedObserver);
		jobCenter.setSubMsg("Ӧ�칤�������ˣ�");
		jobCenter.notifyObserver();

	}

}
