/*
 * ͨ��ʵ��Runnable�ӿڴ����߳���
 */
package Thread;

public class SecondThread implements Runnable{
	private int i;
	/*
	 * �߳�ִ����
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;i<100;i++)
		{
			/*
			 * �߳���ʵ��Runnable�ӿ�ʱ��
			 * ֻ����Thread��currentThread()��������getName()������ȡ��ǰ�߳�
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
				 * ͨ��new Thread().start()�����̣߳�
				 * ��Ҫ����Runnableʵ������󣬿�ָ���߳���
				 */
				new Thread(new SecondThread()).start();
				new Thread(new SecondThread(),"thread-name").start();
			}
		}
	}

}
