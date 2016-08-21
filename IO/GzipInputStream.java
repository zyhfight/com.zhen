package focus.com.zhen.IO;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GzipInputStream {
	public void expandGz(String fromPath){
		GZIPInputStream gzipInputStream=null;
		BufferedOutputStream bufferedOutputStream=null;
		try {
			gzipInputStream=new GZIPInputStream(new FileInputStream(fromPath));
			int to=fromPath.lastIndexOf(".");
			String toPath=fromPath.substring(0,to);
			bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(toPath));
			System.out.println("ÕýÔÚ½âÑ¹£º"+toPath+"...");
			byte[] buffer=new byte[1024];
			while(gzipInputStream.read(buffer)!=-1){
				bufferedOutputStream.write(buffer);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(gzipInputStream!=null){
			
				gzipInputStream.close();
			}
			if(bufferedOutputStream!=null){
				bufferedOutputStream.close();
			}}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
}
