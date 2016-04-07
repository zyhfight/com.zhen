<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<%	
			if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("1"))
			{
				response.sendRedirect("../Login/welcome1.jsp");
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