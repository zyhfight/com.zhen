/*
 * 当所有线程都到达barrier状态后，会从其中选择一个线程去执行Runnable任务。
 */
package focus.com.zhen.Concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
	public static void main(String[] args) {
		int N=4;
		CyclicBarrier cyclicBarrier=new CyclicBarrier(N,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("当前线程："+Thread.currentThread().getName());			
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
