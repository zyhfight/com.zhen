<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="po.*" %>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check2.jsp" %>
<%@ page import="java.text.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重新参与活动</title>
</head>
<body>
	<div align="center"><h1>请选择活动</h1></div>
	<div align="center">
	<form action="invoActivity" method="post">
	<fieldset>
	<fieldset>
	选择活动
			<%
			String usrNname=session.getAttribute("用户名").toString();
			String sql="SELECT * FROM collectAnswer WHERE STUID='"+usrNname+"'";
			List<Object>list=collectAnswerFunction.selectRecord(sql);
			if(list==null)
			{
				out.println("<script>alert('暂时没有活动可以重新参加！');location.href='../Login/welcome2.jsp';</script>");
				return;
			}
			
			out.println("<select name=WID-Activity style=height:40px;width:449px;background-color:#E0EEE0>");
			for(int i=0;i<list.size();i++)
			{
//				System.out.println(((survey)list.get(i)).getWID());
				
					out.println("<option value="+((collectAnswer)list.get(i)).getWID()+"#"+((survey)list.get(i)).getACTIVITY()+"$"+">");
					out.println(((survey)list.get(i)).getACTIVITY()+"("+((survey)list.get(i)).getTEAID()+")"+"</option>");
				
			}
			out.println("</select>");
			%>
			</fieldset>
		<input type="hidden" name="invoActivity" value="invoActivity">
		<input type="submit" value="确定">
		<input type="button" onclick="window.location.href='../Login/welcome2.jsp'" value="取消">
		</fieldset>
	</form>
	</div>
</body>
</html>