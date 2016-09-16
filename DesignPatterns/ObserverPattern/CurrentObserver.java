package DesignPatterns.ObserverPattern;
/**
 * 应届生招聘
 * @author zhen
 *
 */
public class CurrentObserver implements Observer {

	@Override
	public void update(String subMsg) {
		if(subMsg.contains("应届")){
			System.out.println("应聘");
		}else{
			System.out.println("非应届不应聘");
		}
		
	}

	
}
