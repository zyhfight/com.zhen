/*
 * Socket�ͻ���ʵ����ͨ��Socket���ӵ�������������һ������Ȼ��ȴ�һ����Ӧ
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
			 * �ͻ���ʵ����һ��Socket����ָ�����������ƺͶ˿ں�����������
			 * Socket��Ĺ��캯����ͼ���ͻ������ӵ�ָ���ķ������Ͷ˿�
			 */
			Socket client=new Socket(serverName,port);
			System.out.println("Just cnnected to "+client.getRemoteSocketAddress());
			/*
			 * ���ӽ�����ͨ��IOͨ�ţ�client�˵�������ӵ�server��������
			 */
			OutputStream outToServer=client.getOutputStream();
			DataOutputStream out=new DataOutputStream(outToServer);
			out.writeUTF("Hello from "+client.getLocalAddress());
			/*
			 * ���ӽ�����ͨ��IOͨ�ţ�client���������ӵ�server�˵������
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
