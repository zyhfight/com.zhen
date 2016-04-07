<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Session/Session.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="../Session/logOut" method="post">
	<div align=right>
	<img src=smiley.gif alt="Smiley face" width="32" height="32">
	欢迎您,<%out.print(session.getAttribute("用户名"));%>	
	<input type="submit" value="bye">
	<input type="hidden" name="logout" value="logout">
	</div>
	</form>
</body>
</html>