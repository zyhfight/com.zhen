/*
 * Socket客户端实例，通过Socket连接到服务器并发送一个请求，然后等待一个响应
 */
package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient {
	public static void main(String[] args)
	{
		String serverName=args[0];
		int port = Integer.parseInt(args[1]);
		System.out.println("Connecting to "+serverName+" on port "+port);
		try {
			/*
			 * 客户端实例化一个Socket对象，指定服务器名称和端口号来请求连接
			 * Socket类的构造函数试图将客户端连接到指定的服务器和端口
			 */
			Socket client=new Socket(serverName,port);
			System.out.println("Just cnnected to "+client.getRemoteSocketAddress());
			/*
			 * 连接建立后，通过IO通信，client端的输出流接到server端输入流
			 */
			OutputStream outToServer=client.getOutputStream();
			DataOutputStream out=new DataOutputStream(outToServer);
			out.writeUTF("Hello from "+client.getLocalAddress());
			/*
			 * 连接建立后，通过IO通信，client端输入流接到server端的输出流
			 */
			InputStream inFromServer=client.getInputStream();
			DataInputStream in=new DataInputStream(inFromServer);
			System.out.println("Server says "+in.readUTF());
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
