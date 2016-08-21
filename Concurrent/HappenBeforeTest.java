 /*
  * happen-beforeʾ��
  * ָ��������
  * B�߳���ʱ��˳���Ͽ�������A�߳�ִ�С�
  */
package focus.com.zhen.Volatitle;
/*
 * ����Happen-before����Ͳ���Ҫ�����ͬ����ʩ�ˡ�
 * happen-before�����з�����ƫ���ϵ������֮��������������ԡ�
 * eg.�߳�ֻ��start�󣬲���ִ��run�ȷ�����
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
			System.out.println("ThreadA��-- "+flag);	
		}
	}

	static class ThreadB extends Thread {
		public void run() {
			System.out.println("ThreadB��    " + flag);
		}
	}
}
