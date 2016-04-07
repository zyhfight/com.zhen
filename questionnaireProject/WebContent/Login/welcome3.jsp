<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check3.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body>
	
	<h1><font color="red"></font></h1>
	
			<h1>调查问卷系统</h1>
	<table  width="100" height="350" border="1">
	<tr>
		<th>
			<a href="../Administrator/addUsr.jsp" target="_blank">增加用户</a><br />
		</th>
	</tr>
	<tr>
		<th>
			<a href="../Administrator/deleteUsr.jsp" target="_blank">删除用户</a><br/>
		</th>
	</tr>
	<tr>
		<th>
			<a href="../Administrator/checkUsr.jsp" target="_blank">查看用户信息</a><br/>
		</th>
	</tr>
	<tr>
		<th>
			<a href="../Administrator/checklog.jsp" target="_blank">查看日志信息</a><br/>
		</th>
	</tr>
	<tr>
		<th>
			<a href="../Administrator/sethonor.jsp" target="_blank">封号</a><br/>
		</th>
	</tr>
	<tr>
		<th>
			<a href="../Administrator/deknight.jsp" target="_blank">解除封号</a><br/>
		</th>
	</tr>
	</table>
	</body>
</html>