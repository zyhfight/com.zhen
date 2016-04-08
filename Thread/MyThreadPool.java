/*
 * ����ʵ�ּ򵥵��̳߳�
 */
package Thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ʵ��Runnable�ӿڣ�
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
			System.out.println(Thread.currentThread().getName()+"No:"+No+"��iֵΪ"+i);
		}
	}
	
}
/*
 * �̳߳��࣬�ṩ�������ύ�������̳߳صȲ���
 */
class MyFixThreadPool
{
	private boolean bDown=false;
	private boolean bDownNow=false;
	ArrayList<Runnable>list=new ArrayList<Runnable>();
	/*
	 * ��������
	 */
	final ReentrantLock lock=new ReentrantLock();
	/*
	 * ��lock����Condition�������������߳�Э��
	 */
	final Condition cond=lock.newCondition();
	/*
	 * MyThread�ڲ���̳�Thread�ࣻ����ʵ�ִ�����ִ�С������̵߳Ȳ���
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
					 * ���ýӿڻص������߳�ִ����run()����
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
	//�ȴ����ύ�߳�ִ�����
	public void shutDown()
	{
		lock.lock();
		bDown=true;
		cond.signal();
		lock.unlock();
	}
	//����ֹͣ�̡߳�
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
