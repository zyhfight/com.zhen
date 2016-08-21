 /*
  * happen-before示例
  * 指令重排序。
  * B线程在时间顺序上可能先于A线程执行。
  */
package focus.com.zhen.Volatitle;
/*
 * 满足Happen-before规则就不需要额外的同步措施了。
 * happen-before：先行发生，偏序关系。程序之间存在数据依赖性。
 * eg.线程只有start后，才能执行run等方法。
 */
public class HappenBeforeTest {
	
	private static boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<1000;i++){
			ThreadA threadA = new ThreadA();
			ThreadB threadB = new ThreadB();
			flag=true;
			threadA.start();
			threadB.start();
			threadA.join();
			threadB.join();
		}
		flag = false;
	}

	static class ThreadA extends Thread {
		public void run() {	
			flag=false;
			System.out.println("ThreadA：-- "+flag);	
		}
	}

	static class ThreadB extends Thread {
		public void run() {
			System.out.println("ThreadB：    " + flag);
		}
	}
}
