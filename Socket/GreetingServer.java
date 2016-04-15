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
				 * 服务器调用ServerSocket类的accept方法，该方法一直等待，
				 * 直到客户端连接到服务器端上给定的端口；
				 * accept()方法返回服务器上一个新的Socket引用，该Socket连接到客户端的Socket
				 */
				Socket server=serverSocket.accept();
				System.out.println("Just connected to "+server.getRemoteSocketAddress());
				/*
				 * 连接建立后，通过IO通信，server端的输出流接到client端输入流
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
		 * 服务器端实例化一个ServerSocket对象，表示通过服务器上的端口进行通信
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
		 * 启动线程，调用run()方法
		 */
		
	}
}
