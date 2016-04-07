<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check3.jsp" %>
<!DOCTYPE ">
<html>
<head>

<style type="text/css"> 
body { 
    margin:0; 
    padding:0; 
    background:url(image14.jpg);
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
  		if (validate_required(UsrID,"请输入用户名")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户</title>
</head>
<body>
	<%
		if(session.getAttribute("查看用户名")==null)
		{
			out.println("<script>alert('请输入要查看的用户名！');location.href='checkUsr.jsp';</script>");
			session.setAttribute("查看用户名","");
		}
	%>
	<div align="center">
		<h4>查看用户</h4>
		<form method='post' onsubmit="return validate_form(this)" action="checkUsr">
		<fieldset>
		<table  border=1>
			<tr>
				<td>查看用户名：</td>
				<td><input type=text name="UsrID" value="<%=session.getAttribute("查看用户名")%>" placeholder="填写发布人群"  required  style="height:40px;width:449px;background-color:#E0EEE0"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><%=session.getAttribute("密码")%></td>
			</tr>
			<tr>
				<td>身份</td>
				<td><%=session.getAttribute("查看身份")%></td>
			</tr>
			<tr>
				<td>账号状态</td>
				<td><%=session.getAttribute("账号状态")%></td>
			</tr>
			<tr>
				<td></td>
				<td><input type=submit value="确定">
				<input type="button" value="取消" onclick="window.location.href='http://localhost:8080/questionnaireProject/Login/welcome3.jsp'"></td>
			</tr>
		</table>
		<input type="hidden" name="checkUsr" value="checkUsr">
		</fieldset>
	</form>
		</div>
</body>
</html>