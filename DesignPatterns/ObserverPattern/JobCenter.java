package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 求职中心
 * @author zhen
 *
 */
public class JobCenter implements Subject{
	private List<Observer> observerList=new ArrayList<>();
	private String subMsg;
	
	public String getSubMsg() {
		return subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
		
	}

	@Override
	public void deleteObserver(Observer observer) {
		observerList.remove(observer);
		
	}

	@Override
	public void notifyObserver() {
		for(Observer list:observerList){
			list.update(getSubMsg());
		}
		
	}
	
}
