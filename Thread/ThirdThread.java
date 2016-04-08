/*
 *ʵ�� Callable�ӿڴ����߳�
 */
package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread {
	public static void main(String[] args)
	{
		/*
		 * �����ࣻ
		 * ����Callable���󣬲���FutureTask��װCallable����
		 */
		FutureTask<Integer> task=new FutureTask<Integer>(new Callable<Integer>()
				{
					/*
					 * �߳�ִ����
					 */
					@Override
					public Integer call() throws Exception {
						// TODO Auto-generated method stub
						int i=0;
						for(;i<100;i++)
						{
							System.out.println(Thread.currentThread().getName()+" "+i);
						}
						return i;
					}
			
				});
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
				/*
				 * һ��futureTask����ֻ�ɴ���һ���̣߳�
				 * ��Ϊһ��futureTask����ֻ��Ӧһ��Runnable����
				 */
		//		new Thread(task).start();
				new Thread(task,"�з���ֵ���߳�").start();
				try {
					//ʵ��Callable�ӿڴ����̣߳�call()�����з���ֵ�������쳣
					System.out.println("�̷߳���ֵ��"+task.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
