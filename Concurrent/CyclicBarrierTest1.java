/*
 * CyclicBarrier回环栅栏，可以实现让一组线程等待至某个状态之后再全部执行。
 * 回环：所有等待线程释放后，CyclicBarrier可以被重用。
 * 暂且称此状态为barrier，当调用await()方法之后，线程就处于barrier了。
 * 
 * public CyclicBarrier(int parties,Runnable barrierAction){}
 *  public CyclicBarrier(int parties){}
 *  参数parties指让多少个线程或任务等待至barrier状态；barrierAction指当这些线程都到达barrier状态时执行的内容。
 *  
 *1、  public int await(){}
 *2、  public int await(long timeout,TimeUnit unit){}
 *  1：挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务
 *  2：让这些线程等待一定时间，若还有线程没到达barrier状态就直接让到达barrier状态的 线程执行后续任务。
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
			System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
			try{
				Thread.sleep(millions);//以睡眠模拟写入数据操作
				System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
				cyclicBarrier.await();//等待
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("所有线程写入完毕。继续处理其他任务...");
		}
	}
}
