/*
 * CyclicBarrier�ػ�դ��������ʵ����һ���̵߳ȴ���ĳ��״̬֮����ȫ��ִ�С�
 * �ػ������еȴ��߳��ͷź�CyclicBarrier���Ա����á�
 * ���ҳƴ�״̬Ϊbarrier��������await()����֮���߳̾ʹ���barrier�ˡ�
 * 
 * public CyclicBarrier(int parties,Runnable barrierAction){}
 *  public CyclicBarrier(int parties){}
 *  ����partiesָ�ö��ٸ��̻߳�����ȴ���barrier״̬��barrierActionָ����Щ�̶߳�����barrier״̬ʱִ�е����ݡ�
 *  
 *1��  public int await(){}
 *2��  public int await(long timeout,TimeUnit unit){}
 *  1������ǰ�̣߳�ֱ�������̶߳�����barrier״̬��ͬʱִ�к�������
 *  2������Щ�̵߳ȴ�һ��ʱ�䣬�������߳�û����barrier״̬��ֱ���õ���barrier״̬�� �߳�ִ�к�������
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest1 {

	public static void main(String[] args) {
		int N=4;
		CyclicBarrier cyclicBarrier=new CyclicBarrier(N);
		for(int i=0;i<N;i++){
			new Writer(cyclicBarrier,(i+1)*1000).start();;
		}

	}
	static class Writer extends Thread{
		private CyclicBarrier cyclicBarrier;
		private int millions;
		public Writer(CyclicBarrier cyclicBarrier,int millions){
			this.cyclicBarrier=cyclicBarrier;
			this.millions=millions;
		}
		@Override
		public void run(){
			System.out.println("�߳�"+Thread.currentThread().getName()+"����д������...");
			try{
				Thread.sleep(millions);//��˯��ģ��д�����ݲ���
				System.out.println("�߳�"+Thread.currentThread().getName()+"д��������ϣ��ȴ������߳�д�����");
				cyclicBarrier.await();//�ȴ�
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("�����߳�д����ϡ�����������������...");
		}
	}
}
