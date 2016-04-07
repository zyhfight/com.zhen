<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<%
	if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("3"))
	{
		response.sendRedirect("../Login/welcome3.jsp");
		return;
	}
	if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("2"))
	{
		response.sendRedirect("../Login/welcome2.jsp");
		return;
	}
		
	%>
</body>
</html>