/*
 * 通过继承Thread类来创建线程类
 */
package Thread;

public class FirstThread extends Thread{
	private int i;
	/*
	 * 线程执行体
	 */
	public void run()
	{
		for(;i<100;++i)
		{
			/*
			 * 当线程类继承Thread类时，直接使用this即可获取当前线程
			 * Thread对象的getNme()方法返回当前线程名字
			 */
			System.out.println(getName()+" "+i);
		}
	}
	public static void main(String[] args)
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
			//	new Thread().start();
				/*
				 * 创建两个线程
				 */
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}
}
