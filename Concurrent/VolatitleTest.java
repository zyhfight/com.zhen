/*
 * ����ʹ��volatile���α���������volatileֻ�ܱ�֤�ɼ��Ժ��ʵ��������ԣ�������֤ԭ���ԣ�
 * ��������������ԭ���ԣ����Դ˳�����ڲ������⡣
 * ����inc++��Ϊ�����ڴ��ж�ȡinc��������inc���м�1��������incд���ڴ档
 * ����inc=1���߳�1��ȡ����inc�󣬲����жϡ���һ�߳�2��ʱ����inc++����������inc��δ�޸ģ��������ж�ȡinc����1��
 * �߳�2��inc��ȡ���޸Ĳ�д�����档��ʱ������inc=2��
 * �����߳�1�Ѿ���ȡ���ع�inc������������inc�޸ģ�д�ء���inc=2д�����档����������֣�
 * 
 * VolatileӦ�ó�����1��״̬�������2������ģʽ˫�ؼ��
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
	//activeCount�����ػ�̵߳ĵ�ǰ�̵߳��߳����е����������ص�ǰ��̵߳�������
	//yield��ʹ��ǰ�����߳����½����߳��ŶӶ��У�Ŀ�ģ�ʹ�����̣߳�������ͬ���ȼ����߳�֮������ʵ�����תִ�С�
	//whileѭ����֤ǰ����̶߳�ִ���ꡣ
	while(Thread.activeCount()>1){
		Thread.yield();
	}
	System.out.println(test.inc);
}
}
