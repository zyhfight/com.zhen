/**
 * Java's JarURLConnection class is used to connect to a Java Jar file.
 * Once connected you can obtain information about the contents of the Jar file. 
 * 示例有问题，知道有这个的存在即可。
 */
package focus.com.zhen.Socket;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarFile;

public class JarURLTest {

	public static void main(String[] args) {
		String urlString="http://butterfly.jenkov.com/"
				+"container/download/"
                + "jenkov-butterfly-container-2.9.9-beta.jar";
		
		URL jarUrl = null;
		try {
			jarUrl = new URL(urlString);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JarURLConnection jarURLConnection = null;
		try {
			jarURLConnection = new JarURLConnection(jarUrl) {
				
				@Override
				public void connect() throws IOException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public JarFile getJarFile() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
			};
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			JarFile jarFile= jarURLConnection.getJarFile();
			System.out.println(jarFile.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
