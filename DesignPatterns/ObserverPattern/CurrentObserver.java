package DesignPatterns.ObserverPattern;
/**
 * Ӧ������Ƹ
 * @author zhen
 *
 */
public class CurrentObserver implements Observer {

	@Override
	public void update(String subMsg) {
		if(subMsg.contains("Ӧ��")){
			System.out.println("ӦƸ");
		}else{
			System.out.println("��Ӧ�첻ӦƸ");
		}
		
	}

	
}
