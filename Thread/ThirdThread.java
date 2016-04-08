/*
 *实现 Callable接口创建线程
 */
package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread {
	public static void main(String[] args)
	{
		/*
		 * 匿名类；
		 * 创建Callable对象，并用FutureTask包装Callable对象
		 */
		FutureTask<Integer> task=new FutureTask<Integer>(new Callable<Integer>()
				{
					/*
					 * 线程执行体
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
				 * 一个futureTask对象只可创建一次线程；
				 * 因为一个futureTask对象只对应一个Runnable对象
				 */
		//		new Thread(task).start();
				new Thread(task,"有返回值的线程").start();
				try {
					//实现Callable接口创建线程，call()方法有返回值且声明异常
					System.out.println("线程返回值："+task.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
