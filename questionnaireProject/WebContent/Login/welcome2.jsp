<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check2.jsp" %>
<%@ page import="service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
<style type="text/css">
body { 
    margin:0; 
    padding:0; 
    background:url(image1.jpg);
    background-size:cover;
} 
</style>
<style type="text/css">
<!--
a {text-transform:none;text-decoration:none;} 
a:hover {text-decoration:underline} 
-->
</style> 
</head>
<body>
	<%
	String wsql="SELECT * FROM Student WHERE STUID='"+session.getAttribute("用户名").toString()+"'";
	//		System.out.println("查询学员是否完善信息sql语句"+wsql);
	if(shareFunction.selectStudentInformation(wsql)==null)
	{
		out.println("<script>alert('请完善个人信息');</script>");
		session.setAttribute("warning", "请完善个人信息");
	}
	else
	{
		session.setAttribute("warning", "欢迎使用问卷系统");
	}
	%>
	<div align="left">
	<br>
	<table  width="100" height="400" border="1">
	<tr>
		<th>
			<a href="../Student/invoActivity.jsp" >参与活动</a><br />
		</th>
	</tr>
	
	<tr>
		<th>
			<a href="../share/completeInformation.jsp" >完善个人信息</a><br/>
		</th>	
	</tr>
	<tr>
		<th>
			<a href="../share/loadInformation.jsp" >重新载入个人信息</a><br/>
		</th>
	</tr>
	<tr>
		<th>
			<a href="../share/updatePassWord.jsp">修改密码</a><br/>
		</th>
	</tr>
	</table>
	</div>
</body>
</html>