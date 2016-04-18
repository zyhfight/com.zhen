package com.zhen.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*可防止大文件被截断*/
public class ServletPostReader {
	public static String getContent(HttpServletRequest request,HttpServletResponse response)
	{
		String req="";
		int len=request.getContentLength();
		byte[] buffer=new byte[len];
		try {
			InputStream in=request.getInputStream();
			int total=0;
			int once=0;
			/*
			 * 偏移量，尽量读
			 */
			while(total<len&&once>=0)
			{
				once=in.read(buffer,total,len);
				total+=once;
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			req=new String(buffer,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return req;
	}
}
