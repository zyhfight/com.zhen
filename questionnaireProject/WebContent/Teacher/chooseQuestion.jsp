<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored ="true" %>
<%@ page import="po.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<%@ page import="ServiceInterface.*" %>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check1.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type=text/css> 
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
<title>选题</title>
</head>
<body>
	<div align="right"><a href="addRestrict.jsp" target="_blank" style="font-weight: bold; font-size:20px;background-color:#3A5FCD">
	添加约束条件</a><br /></div>
	<div align="right"><a href="addQuestion.jsp" target="_blank" style="font-weight: bold; font-size:20px;background-color:#3A5FCD">
	录入题目</a><br /></div><br>
	<fieldset>
			<h3>	问卷主题：
				<%=session.getAttribute("主题") %></h3>
	</fieldset>	
	<form method=post onsubmit="return validate_form(this)" action="chooseQuestion">
	<fieldset>
	<%
	String teaId=session.getAttribute("用户名").toString();
	String sql="SELECT * FROM QUESTION WHERE TEAID='"+teaId+"'";
	System.out.println("查询题目表的sql语句"+sql);
	questionnaireInterface quObj=new questionFunction();
	List<Object>list=quObj.selectRecord(sql);
	if(list==null)
	{
		out.println("<script>alert('无题目信息，请录入答案！');location.href='addQuestion.jsp';</script>");
		return;
	}
		if(session.getAttribute("题目数")==null)
			return;
		for(int i=1;i<=Integer.parseInt(session.getAttribute("题目数").toString());i++)
		{
			out.println("<div align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+"题目"+i+"<select name='"+i+"' style=height:40px;width:449px;background-color:#E0EEE0>");
			for(int j=0;j<list.size();j++)
			{
				out.println("<option value="+((question)list.get(j)).getTID()+">"+((question)list.get(j)).getStem()+"</option>");
				out.println("<br>");
			}
			out.println("</select></div>");
		}
	
	%>
	<div align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;<input type="submit" value="确定">
			<input type="button" value="取消" onclick="window.location.href='../Login/welcome1.jsp'">
			</div>
	</fieldset>
	</form>
</body>
</html>