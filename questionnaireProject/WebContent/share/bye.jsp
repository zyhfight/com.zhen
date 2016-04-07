<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="service.*" %>
<%@ page import="po.*" %>
<%@ include file="../Session/Session.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
	if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("1"))
	{
		response.sendRedirect("../Login/Home.jsp");
		return;
	}
	if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("3"))
	{
		response.sendRedirect("../Login/Home.jsp");
		return;
	}
	if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("2"))
	{
		response.sendRedirect("../Login/welcome2.jsp");
		return;
	}
	
	
	//退出者身份（用户名）
			if(session.getAttribute("用户名")==null)
			{
				out.println("<script>alert('请登录!');location.href='../Login/Home.jsp';</script>");
				return;
			}
			String usrName=session.getAttribute("用户名").toString();
			//退出时间
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);			
			//退出时ip地址
		//	InetAddress addr = InetAddress.getLocalHost();
		//	String ipAddress=addr.getHostAddress();//获得本机IP
			String ipAddress = null;
			try
			{
				ipAddress=request.getRemoteHost();
				System.out.println("ip地址："+ipAddress);
			}catch(Exception e){
				e.getMessage();
			}
//			System.out.println("ip地址："+ipAddress);
			//添加log信息
			log logObj=new log();
			logObj.setUsrName(usrName);
			logObj.setTime(time);
			logObj.setIpAddress(ipAddress);
			logObj.setOperation("logout");
			//添加日志信息
			logFunction.insertLog(logObj);
			session.setAttribute("用户名", null);
			response.sendRedirect("../Login/Home.jsp");
	%>
</body>
</html>