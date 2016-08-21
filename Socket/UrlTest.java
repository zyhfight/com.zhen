/**
 * ����URL��URLConnection�ഴ���ͻ��˵�web��������HTTP��������������
 */
package focus.com.zhen.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {

	public static void main(String[] args) {
		//�ӷ������˻�ȡ���ݡ�
		/*InputStream input = null;
		try {
			//�����ͻ�����web��������HTTP��������֮������ӡ�
//			URL url = new URL("http://www.baidu.com");
			//URL��ͳһ��Դ��λ����URLҲ���Դ򿪱����ļ���
			URL url = new URL("file:/C:/data/test.txt");
			URLConnection urlConnection = url.openConnection();
			input = urlConnection.getInputStream();
			byte[] buffer = new byte[1024];
			while ( input.read(buffer) != -1) {
				System.out.println(new String(buffer) );
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
		//����������ύ����
		OutputStream outputStream=null;
		try {
			//�����ͻ�����web��������HTTP��������֮������ӡ�
//			URL url = new URL("http://www.baidu.com");
			//URL��ͳһ��Դ��λ����URL��֧���򱾵��ļ�д�룡��
			URL url = new URL("http://www.baidu.com");
			URLConnection urlConnection = url.openConnection();
			//����һ��HTTP POST����
			urlConnection.setDoOutput(true);
			outputStream= urlConnection.getOutputStream();
			outputStream.write("hello world".getBytes());
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
