package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class GreetingServer extends Thread{
	private ServerSocket serverSocket;
	public GreetingServer(int port) throws IOException
	{
		serverSocket=new ServerSocket(port);
		serverSocket.setSoTimeout(60000);
			
		
	}
	public void run()
	{
		while(true)
		{
			System.out.println("Waiting for client on port "+
					serverSocket.getLocalPort()+"...");
			try {
				/*
				 * ����������ServerSocket���accept�������÷���һֱ�ȴ���
				 * ֱ���ͻ������ӵ����������ϸ����Ķ˿ڣ�
				 * accept()�������ط�������һ���µ�Socket���ã���Socket���ӵ��ͻ��˵�Socket
				 */
				Socket server=serverSocket.accept();
				System.out.println("Just connected to "+server.getRemoteSocketAddress());
				/*
				 * ���ӽ�����ͨ��IOͨ�ţ�server�˵�������ӵ�client��������
				 */
				DataOutputStream out=new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to "+server.getLocalSocketAddress()
						+"\nGoodbye!");
				DataInputStream in=new DataInputStream(server.getInputStream());
				System.out.println("Client says "+in.readUTF());
				server.close();
			}catch(SocketTimeoutException s)
			{
				System.out.print("Socket times out!");
				break;
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
		}
	}
	public static void main(String[] args)
	{
		int port=Integer.parseInt(args[0]);
		/*
		 * ��������ʵ����һ��ServerSocket���󣬱�ʾͨ���������ϵĶ˿ڽ���ͨ��
		 */
		Thread t;
		try {
			t = new GreetingServer(port);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * �����̣߳�����run()����
		 */
		
	}
}
