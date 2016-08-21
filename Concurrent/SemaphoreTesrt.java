/*
 * Semaphore:信号量；
 * 它可以控制同时访问的线程数，通过acquire()获取许可。若没有就等待。
 * release()释放一个许可，释放前必须先获取。
 * public Semaphore(int permits){}//permits表示许可数目，即同时允许多少线程进行访问
 * public Semaphore(int permits,boolean fair){}//fair表示是否公平，即等待时间越久的越先获取许可
 * 
 * public void acquire(){}//获取一个许可
 * public void acquire(int permits){}//获取permits个许可
 * public void release(){}//释放一个许可
 * public void release(int permits){}//释放permits个许可 
 * 此上4个方法都会阻塞。
 * 
 * 若想立即获取结果，可使用：
 * public void tryacquire(){}//尝试获取一个许可，若成功，立即返回true，否则返回false
 * public void tryacquire(long timeout,Timeunit unit){}//尝试获取一个许可，若在指定时间成功，立即返回true，否则返回false
 * public void tryacquire(int permits){}//尝试获取permits个许可，若成功，立即返回true，否则返回false
 * public void tryacquire(int permits,long timeout,Timeunit unit){}//尝试获取permits个许可，若在指定时间成功，立即返回true，否则返回false
 * 
 * 
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.Semaphore;

//eg.一个工厂8个工人，5台机器，一台机器只能同时被一个工人使用。只有使用完了，其他工人才能继续使用。
public class SemaphoreTesrt {

	public static void main(String[] args) {
		int N=8;//8个工人
		Semaphore semaphore=new Semaphore(5);//5个机器。
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
				
				semaphore.acquire();//工人使用机器
				System.out.println("工人"+this.num+"占用一个机器生产..."+"    "+"还有"+semaphore.availablePermits()+"机器可用");
				Thread.sleep(2000);//模仿工人使用机器生产
				System.out.println("工人"+this.num+"释放出机器"+"    "+"还有"+(semaphore.availablePermits()+1)+"机器可用");
				semaphore.release();//工人释放机器
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
