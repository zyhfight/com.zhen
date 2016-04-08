/*
 * 自行实现简单的线程池
 */
package Thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 实现Runnable接口；
 */
class MyRunnable implements Runnable
{
	int No;
	public MyRunnable(){}
	public MyRunnable(int No)
	{
		this.No=No;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+"No:"+No+"的i值为"+i);
		}
	}
	
}
/*
 * 线程池类，提供创建、提交、结束线程池等操作
 */
class MyFixThreadPool
{
	private boolean bDown=false;
	private boolean bDownNow=false;
	ArrayList<Runnable>list=new ArrayList<Runnable>();
	/*
	 * 可重入锁
	 */
	final ReentrantLock lock=new ReentrantLock();
	/*
	 * 由lock创建Condition条件变量控制线程协调
	 */
	final Condition cond=lock.newCondition();
	/*
	 * MyThread内部类继承Thread类；具体实现创建、执行、结束线程等操作
	 */
	class MyThread extends Thread
	{
		public MyThread(String name)
		{
			super(name);
		}
		public void run()
		{
			while(true)
			{
				if(bDownNow)
					break;
				Runnable run=null;
				lock.lock();
				if(!list.isEmpty())
				{
					run=list.get(0);
					list.remove(0);
				}else
				{
					if(bDown)
					{
						lock.unlock();
						break;
					}
					try {
						cond.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
				}
				lock.unlock();
				if(run!=null)
				{
					/*
					 * 利用接口回调启用线程执行体run()方法
					 */
					run.run();
				}
			}
		}
	}
	public MyFixThreadPool(){
		String name="thread-0";
		new MyThread(name).start();
	}
	public MyFixThreadPool(int maxThread)
	{
		for(int i=0;i<maxThread;++i)
		{
			String name="thread-"+i;
			new MyThread(name).start();
		}
	}
	public void submit(Runnable run)
	{
		lock.lock();
		list.add(run);
		cond.signal();
		lock.unlock();
	}
	//等待已提交线程执行完毕
	public void shutDown()
	{
		lock.lock();
		bDown=true;
		cond.signal();
		lock.unlock();
	}
	//立刻停止线程。
	public void shutDownNow()
	{
		lock.lock();
		bDownNow=true;
		list.clear();
		cond.signal();
		lock.unlock();
	}
}
public class MyThreadPool {
	public static void main(String[] args)
	{
		MyFixThreadPool pool=new MyFixThreadPool(3);
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		pool.shutDown();
	}
	
	
}
