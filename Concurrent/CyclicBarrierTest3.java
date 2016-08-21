/*
 * cyclicBarrier.await(1000,TimeUnit.MICROSECONDS);
 * �ȴ�һ��ʱ��󣬻����߳�δ����barrier״̬�����׳��쳣������ִ�к��������
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;



public class CyclicBarrierTest3 {

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
				cyclicBarrier.await(1000,TimeUnit.MICROSECONDS);//�ȴ�1s;TimeUnit:ʱ�䵥λ��
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("�����߳�д����ϡ�����������������...");
		}
	}

}
