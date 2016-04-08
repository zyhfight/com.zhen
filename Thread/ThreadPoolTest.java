/*
 * �̳߳�
 */
package Thread;

import java.util.concurrent.*;

class MyRun implements Runnable{
	int No;
	public MyRun(){}
	public MyRun(int No)
	{
		this.No=No;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;++i)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
}
public class ThreadPoolTest {
	public static void main(String[] args)
	{
		/*
		 * ����Executors�������������̳߳�
		 * newScheduledTreadPool()�����ɵ��ȵ��̳߳أ�
		 * newFixedThreadPool()������ͨ���̳߳�
		 */
		ExecutorService pool=Executors.newFixedThreadPool(5);
		pool.submit(new MyRun());
		pool.submit(new MyRun());
		pool.submit(new MyRun());
		pool.shutdown();
	}
}
