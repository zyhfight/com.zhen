package com.zhen.service;
/*
 * 自动回复类
 */
import java.io.PrintWriter;

import com.zhen.po.Xml;

public class AutoReply {
	public static void autoReply(String data,PrintWriter out)
	{
		/*
		 * 将用户发送的消息（xml文件字符串）解析为相应xml实体类对象
		 */
		Xml obj=XmlResolution.resolutionXml(data);
		/*
		 * 将要自动回复的消息写回服务器（发送给微信关注者）
		 */
		out.write(XmlResolution.outXml(obj));
	}
}
