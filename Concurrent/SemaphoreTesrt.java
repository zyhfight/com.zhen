/*
 * Semaphore:�ź�����
 * �����Կ���ͬʱ���ʵ��߳�����ͨ��acquire()��ȡ��ɡ���û�о͵ȴ���
 * release()�ͷ�һ����ɣ��ͷ�ǰ�����Ȼ�ȡ��
 * public Semaphore(int permits){}//permits��ʾ�����Ŀ����ͬʱ��������߳̽��з���
 * public Semaphore(int permits,boolean fair){}//fair��ʾ�Ƿ�ƽ�����ȴ�ʱ��Խ�õ�Խ�Ȼ�ȡ���
 * 
 * public void acquire(){}//��ȡһ�����
 * public void acquire(int permits){}//��ȡpermits�����
 * public void release(){}//�ͷ�һ�����
 * public void release(int permits){}//�ͷ�permits����� 
 * ����4����������������
 * 
 * ����������ȡ�������ʹ�ã�
 * public void tryacquire(){}//���Ի�ȡһ����ɣ����ɹ�����������true�����򷵻�false
 * public void tryacquire(long timeout,Timeunit unit){}//���Ի�ȡһ����ɣ�����ָ��ʱ��ɹ�����������true�����򷵻�false
 * public void tryacquire(int permits){}//���Ի�ȡpermits����ɣ����ɹ�����������true�����򷵻�false
 * public void tryacquire(int permits,long timeout,Timeunit unit){}//���Ի�ȡpermits����ɣ�����ָ��ʱ��ɹ�����������true�����򷵻�false
 * 
 * 
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.Semaphore;

//eg.һ������8�����ˣ�5̨������һ̨����ֻ��ͬʱ��һ������ʹ�á�ֻ��ʹ�����ˣ��������˲��ܼ���ʹ�á�
public class SemaphoreTesrt {

	public static void main(String[] args) {
		int N=8;//8������
		Semaphore semaphore=new Semaphore(5);//5��������
		for(int i=1;i<=N;++i){
			new Worker(i, semaphore).start();
		}
	}
	static class Worker extends Thread{
		private int num;
		private Semaphore semaphore;
		public Worker(int num,Semaphore semaphore){
			this.num=num;
			this.semaphore=semaphore;
		}
		@Override
		public void run(){
			try {
				
				semaphore.acquire();//����ʹ�û���
				System.out.println("����"+this.num+"ռ��һ����������..."+"    "+"����"+semaphore.availablePermits()+"��������");
				Thread.sleep(2000);//ģ�¹���ʹ�û�������
				System.out.println("����"+this.num+"�ͷų�����"+"    "+"����"+(semaphore.availablePermits()+1)+"��������");
				semaphore.release();//�����ͷŻ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
