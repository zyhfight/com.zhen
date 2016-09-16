package DesignPatterns.ObserverPattern;
/**
 * ��ְ��Ϣ����
 * @author zhen
 *
 */
public interface Subject {
	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public void notifyObserver();
}
