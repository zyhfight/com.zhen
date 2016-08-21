/*
 * 尽管使用volatile修饰变量，但是volatile只能保证可见性和适当地有序性，并不保证原子性！
 * 自增操作不具有原子性，所以此程序存在并发问题。
 * 即：inc++分为：从内存中读取inc操作、对inc进行加1操作、将inc写会内存。
 * 假设inc=1；线程1读取加载inc后，操作中断。另一线程2此时进行inc++操作，由于inc还未修改，从主存中读取inc仍是1，
 * 线程2对inc读取、修改并写回主存。此时主存中inc=2。
 * 由于线程1已经读取加载过inc变量，继续对inc修改，写回。将inc=2写回主存。并发问题出现！
 * 
 * Volatile应用场景：1、状态标记量，2、单例模式双重检查
 */
package focus.com.zhen.Volatitle;

public class VolatitleTest {
	public volatile int inc=0;
	public void increase(){
		inc++;
	}
public static void main(String[] args) {
	final VolatitleTest test=new VolatitleTest();
	for(int i=0;i<10;i++){
		new Thread(){
			public void run(){
				for(int j=0;j<1000;j++){
					test.increase();
				}
			};
		}.start();
	}
	//activeCount：返回活动线程的当前线程的线程组中的数量（返回当前活动线程的数量）
	//yield：使当前运行线程重新进入线程排队队列；目的：使（各线程）具有相同优先级的线程之间可以适当地轮转执行。
	//while循环保证前面的线程都执行完。
	while(Thread.activeCount()>1){
		Thread.yield();
	}
	System.out.println(test.inc);
}
}
