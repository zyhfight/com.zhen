/*
 * 通过实现Runnable接口创建线程类
 */
package Thread;

public class SecondThread implements Runnable{
	private int i;
	/*
	 * 线程执行体
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;i<100;i++)
		{
			/*
			 * 线程类实现Runnable接口时；
			 * 只能用Thread。currentThread()方法调用getName()方法获取当前线程
			 */
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	public static void main(String[] args)
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
				/*
				 * 通过new Thread().start()启动线程；
				 * 需要传入Runnable实现类对象，可指定线程名
				 */
				new Thread(new SecondThread()).start();
				new Thread(new SecondThread(),"thread-name").start();
			}
		}
	}

}
