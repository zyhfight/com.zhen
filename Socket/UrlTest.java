/**
 * 利用URL、URLConnection类创建客户端到web服务器（HTTP服务器）的连接
 */
package focus.com.zhen.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {

	public static void main(String[] args) {
		//从服务器端获取数据。
		/*InputStream input = null;
		try {
			//创建客户端与web服务器（HTTP服务器）之间的连接。
//			URL url = new URL("http://www.baidu.com");
			//URL：统一资源定位符。URL也可以打开本地文件。
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
		
		//向服务器端提交数据
		OutputStream outputStream=null;
		try {
			//创建客户端与web服务器（HTTP服务器）之间的连接。
//			URL url = new URL("http://www.baidu.com");
			//URL：统一资源定位符。URL不支持向本地文件写入！。
			URL url = new URL("http://www.baidu.com");
			URLConnection urlConnection = url.openConnection();
			//发送一个HTTP POST请求
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
