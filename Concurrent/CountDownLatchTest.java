/*
 * CountDownLatch类可以实现类似计数器的功能。
 * eg.任务A，它要等待其他4个任务执行完毕后才能执行。
 * 其只提供一个构造器：
 * public CountDownLatch(int count){}//count为计数值
 * public void await（）{}//调用此方法的线程会被挂起，他会等待直到count值为0才继续执行。
 * public boolean await（long timeout，TimeUnit unit）{}//和await()方法类似，不过等待一定时间后，count值即使还未变为0仍会执行。
 * public void countDown{}//将count值减1
 * 
 * CountDownLatch不可复用
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch=new CountDownLatch(2);
		new Thread(){
			public void run(){
				try {
					System.out.println("子线程"+Thread.currentThread().getName()+"正在执行...");
					Thread.sleep(3000);
					System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
					//计数器减1
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
					System.out.println("子线程"+Thread.currentThread().getName()+"正在执行...");
					Thread.sleep(3000);
					System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
					//计数器减1
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
		
		try {
			System.out.println("等待2个子线程执行完毕...");
			//等待2个子线程执行完毕
			countDownLatch.await();
			System.out.println("继续执行主线程...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
