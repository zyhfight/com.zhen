package DesignPatterns.ObserverPattern;
/**
 * 求职信息更新
 * @author zhen
 *
 */
public interface Subject {
	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public void notifyObserver();
}
