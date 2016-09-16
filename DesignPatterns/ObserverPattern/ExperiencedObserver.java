package DesignPatterns.ObserverPattern;
 /**
  * 社会招聘
  * @author zhen
  *
  */
public class ExperiencedObserver implements Observer {

	@Override
	public void update(String subMsg) {
		if(subMsg.contains("社招")){
			System.out.println("应聘");
		}else{
			System.out.println("非社招不应聘");
		}
		
	}

	

}
