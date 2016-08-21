/*
 * �������̶߳�����barrier״̬�󣬻������ѡ��һ���߳�ȥִ��Runnable����
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
	public static void main(String[] args) {
		int N=4;
		CyclicBarrier cyclicBarrier=new CyclicBarrier(N,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName());			
			}
		});
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
