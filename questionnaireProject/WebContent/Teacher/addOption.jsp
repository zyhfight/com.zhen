<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored ="true" %>
<%@ page import="po.answer" %>
<%@ page import="java.util.*" %>
<%@ page import="service.selectRecord" %>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check1.jsp" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css"> 
body { 
    margin:0; 
    padding:0; 
    background:url(image8.jpg);
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

<script type="text/javascript">
function validate_required(field,alerttxt)
	{
		with (field)
  	{
  		if (value==null||value=="")
    	{	alert(alerttxt);
    		return false
    	}
 	    else 
 	    {
 	    	return true
 	    	}
  	}
}
function validate_form(thisform)
	{
		with (thisform)
  	{
  		if (validate_required(stem,"请输入题干")==false||
  				validate_required(optionNum,"请输入选项个数")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请选择题目答案</title>
</head>
<body>
	<div align="left"><br>
	<div align="right"><a href="enterAnswer.jsp" target="_blank" style="font-weight: bold; font-size:20px;background-color:#3A5FCD">
	录入答案</a><br /></div><br>
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;主题：<%=session.getAttribute("主题") %></h2>
		
		
		<h4>&nbsp;&nbsp;&nbsp;&nbsp;
		<%=session.getAttribute("题号")%>、<%=session.getAttribute("题干") %></h4>
	
		<form action="addOption" onsubmit="return validate_form(this)" method="post">
			<fieldset>
			<%
			String teaId=session.getAttribute("用户名").toString();
			String sql="SELECT * FROM ANSWER WHERE TEAID='"+teaId+"'";
//			System.out.println("查询答案表的sql语句"+sql);
			List<Object>list=selectRecord.selectAnswerTable(sql);
			if(list==null)
			{
				out.println("<script>alert('无答案信息，请录入答案！');location.href='enterAnswer.jsp';</script>");
				return;
			}
				if(session.getAttribute("选项个数")==null)
					return;
				for(int i=1;i<=Integer.parseInt(session.getAttribute("选项个数").toString());i++)
				{
					out.println("<div align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+"选项"+i+"<select name='"+i+"' style=height:40px;width:449px;background-color:#E0EEE0>");
					for(int j=0;j<list.size();j++)
					{
						out.println("<option value="+(((answer)list.get(j)).getAnswerID())+">"+((answer)list.get(j)).getContent()+"</option>");
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
			<input type="hidden" name="addOption" value="addOption">
			</fieldset>
		</form>
	</div>
</body>
</html>