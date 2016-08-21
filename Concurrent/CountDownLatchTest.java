/*
 * CountDownLatch�����ʵ�����Ƽ������Ĺ��ܡ�
 * eg.����A����Ҫ�ȴ�����4������ִ����Ϻ����ִ�С�
 * ��ֻ�ṩһ����������
 * public CountDownLatch(int count){}//countΪ����ֵ
 * public void await����{}//���ô˷������̻߳ᱻ��������ȴ�ֱ��countֵΪ0�ż���ִ�С�
 * public boolean await��long timeout��TimeUnit unit��{}//��await()�������ƣ������ȴ�һ��ʱ���countֵ��ʹ��δ��Ϊ0�Ի�ִ�С�
 * public void countDown{}//��countֵ��1
 * 
 * CountDownLatch���ɸ���
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch=new CountDownLatch(2);
		new Thread(){
			public void run(){
				try {
					System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��...");
					Thread.sleep(3000);
					System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����");
					//��������1
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
		new Thread(){
			public void run(){
				try {
					System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��...");
					Thread.sleep(3000);
					System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����");
					//��������1
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
		
		try {
			System.out.println("�ȴ�2�����߳�ִ�����...");
			//�ȴ�2�����߳�ִ�����
			countDownLatch.await();
			System.out.println("����ִ�����߳�...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
