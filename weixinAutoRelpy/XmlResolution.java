package com.zhen.service;
/*
 * 解析xml文件字符串类
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;

import com.zhen.po.Xml;

public class XmlResolution {
	/*
	 * 将xml实体类对象转为要写回的xml文件字符串
	 */
	public static String outXml(Xml obj)
	{
		Document doc=DocumentHelper.createDocument();
		Element xml=doc.addElement("xml");
		Element toUserName=xml.addElement("ToUserName");
		toUserName.addCDATA(obj.getToUserName());
		Element fromUserName=xml.addElement("FromUserName");
		fromUserName.addCDATA(obj.getFromUserName());
		Element msgType=xml.addElement("MsgType");
		msgType.addCDATA(obj.getMsgType());
		Element content=xml.addElement("Content");
		InputStream in=XmlResolution.class.getClassLoader().getResourceAsStream("precut.properties");
		Properties pro=new Properties();
		try {
			pro.load(in);
			String str=pro.getProperty(obj.getContent());
			if(str!=null)
			{
				content.addCDATA(str);
			}else
			{
				content.addCDATA(pro.getProperty(".*"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element createTime=xml.addElement("CreateTime");
		createTime.addCDATA(Long.toString(new Date().getTime()));
		
		
		System.out.println(doc.asXML());
		
		return doc.asXML();
	}
	/*
	 * 将微信服务器传来的xml文件字符串（包含关注者发送的消息）解析为相应的xml实体类对象
	 */
	public static Xml resolutionXml(String data)
	{
		try {
			Document doc=DocumentHelper.parseText(data);
			MyVisitor myObj=new MyVisitor();
			doc.accept(myObj);
			return myObj.outXml();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
/*
 * MyVisitor类：继承VisitorSupport类并重写visit(Element node)方法，
 * 访问xml文件字符串数据，并将数据传入Xml类对象中
 */
class MyVisitor extends VisitorSupport{
	Xml obj=new Xml();
	@Override
	public void visit(Element node)
	{
		if(node.getName().equals("xml"))
			obj.setXml(node.getTextTrim());
		if(node.getName().equals("ToUserName"))
			obj.setFromUserName(node.getTextTrim());
		if(node.getName().equals("FromUserName"))
			obj.setToUserName(node.getTextTrim());
		if(node.getName().equals("MsgType"))
			obj.setMsgType(node.getTextTrim());
		if(node.getName().equals("Content"))
			obj.setContent(node.getTextTrim());
	}
	public Xml outXml()
	{
		return obj;
	}
}
