<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>
<%@ page import="service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="po.*" %>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check2.jsp" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css"> 
body { 
    margin:0; 
    padding:0; 
    background:url(image5.jpg);
    background-size:cover;
} 
fieldset { 
    border:none; 
    padding:10px 10px 0; 
} 
fieldset input[type=submit] { 
    text-align:center; 
    padding:2px 20px; 
    line-height:2em; 
    border:1px solid #FF1500; 
    border-radius:3px; 
    background: -webkit-gradient(linear, left top, left 24, from(#FF6900), color-stop(0%, #FF9800), to(#FF6900)); 
    background: -moz-linear-gradient(top, #FF6900, #FF9800 0, #FF6900 24px); 
    background:-o-linear-gradient(top, #FF6900, #FF9800 0, #FF6900 24px); 
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF9800', endColorstr='#FF6900'); 
    -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF9800', endColorstr='#FF6900')"; 
    height:30px; 
    cursor:pointer; 
    letter-spacing: 4px; 
    margin-left:10px; 
    color:#FFF; 
    font-weight:bold; 
} 
fieldset input[type=submit]:hover { 
    background: -webkit-gradient(linear, left top, left 24, from(#FF9800), color-stop(0%, #FF6900), to(#FF9800)); 
    background: -moz-linear-gradient(top, #FF9800, #FF6900 0, #FF9800 24px); 
    background:-o-linear-gradient(top, #FF6900, #FF6900 0, #FF9800 24px); 
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF6900', endColorstr='#FF9800'); 
    -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF6900', endColorstr='#FF9800')"; 
} 
fieldset input[type=button] { 
    text-align:center; 
    padding:2px 20px; 
    line-height:2em; 
    border:1px solid #FF1500; 
    border-radius:3px; 
    background: -webkit-gradient(linear, left top, left 24, from(#FF6900), color-stop(0%, #FF9800), to(#FF6900)); 
    background: -moz-linear-gradient(top, #FF6900, #FF9800 0, #FF6900 24px); 
    background:-o-linear-gradient(top, #FF6900, #FF9800 0, #FF6900 24px); 
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF9800', endColorstr='#FF6900'); 
    -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF9800', endColorstr='#FF6900')"; 
    height:30px; 
    cursor:pointer; 
    letter-spacing: 4px; 
    margin-left:10px; 
    color:#FFF; 
    font-weight:bold; 
} 
fieldset input[type=button]:hover { 
    background: -webkit-gradient(linear, left top, left 24, from(#FF9800), color-stop(0%, #FF6900), to(#FF9800)); 
    background: -moz-linear-gradient(top, #FF9800, #FF6900 0, #FF9800 24px); 
    background:-o-linear-gradient(top, #FF6900, #FF6900 0, #FF9800 24px); 
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF6900', endColorstr='#FF9800'); 
    -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF6900', endColorstr='#FF9800')"; 
} 
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请选择活动</title>
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
			String sql="SELECT * FROM SURVEY";
			List<Object>list=surveyFunction.selectRecord(sql);
			if(list==null)
			{
				out.println("<script>alert('暂时没有活动可以参加！');location.href='../Login/welcome2.jsp';</script>");
				return;
			}
			
			
			out.println("<select name=WID-Activity style=height:40px;width:449px;background-color:#E0EEE0>");
			for(int i=0;i<list.size();i++)
			{
//				System.out.println(((survey)list.get(i)).getWID());
				if(!usrNname.contains(((survey)list.get(i)).getMYGROUP()))
				{
					out.println("<script>alert('暂时没有活动可以参加！');location.href='../Login/welcome2.jsp';</script>");
					return;
				}
				String endTime=((survey)list.get(i)).getENDTIME();
				String startTime=((survey)list.get(i)).getSTARTTIME();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date time=dateFormat.parse(endTime);
				if(usrNname.contains(((survey)list.get(i)).getMYGROUP())&&time.after(new Date()))
				{
					out.println("<option value="+((survey)list.get(i)).getWID()+"#"+((survey)list.get(i)).getACTIVITY()+"$"+">");
					out.println(((survey)list.get(i)).getACTIVITY()+"("+((survey)list.get(i)).getTEAID()+")"+"</option>");
				}
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