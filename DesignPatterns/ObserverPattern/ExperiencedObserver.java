package DesignPatterns.ObserverPattern;
 /**
  * �����Ƹ
  * @author zhen
  *
  */
public class ExperiencedObserver implements Observer {

	@Override
	public void update(String subMsg) {
		if(subMsg.contains("����")){
			System.out.println("ӦƸ");
		}else{
			System.out.println("�����в�ӦƸ");
		}
		
	}

	

}
