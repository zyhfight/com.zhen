<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check2.jsp" %>
<%@ page import="service.*" %>
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
fieldset input[type=reset] { 
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
fieldset input[type=reset]:hover { 
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
  		if (validate_required(stuName,"请输入姓名")==false||
  				validate_required(stuMail,"请输入邮箱")==false||
  				validate_required(stuTelphone,"请输入联系号码")==false||
  				validate_required(stuClass,"请输入班级")==false||
  				validate_required(stuSchool,"请输入邮箱")==false||
  				validate_required(stuMajor,"请输入专业")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>完善信息</title>
</head>
<body>
<%
		String sql="SELECT * FROM Student WHERE STUID='"+session.getAttribute("用户名").toString()+"'";
		if(shareFunction.selectStudentInformation(sql)!=null)
		{
			out.println("<script>alert('信息已经完善');location.href='../Login/welcome2.jsp';</script>");
		}
%>
	<div align="center">
		<form action="completeInformation" onsubmit="return validate_form(this)" method="post">
		<fieldset>
			<legend style="font-weight: bold">学号:<%=session.getAttribute("用户名") %></legend>
		<fieldset>
				班级<input type="text" pattern="^[0-9]*$" name=stuClass title="输入数字" placeholder="填写班级（数字）"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</fieldset>
		<fieldset>
				姓名<input type="text"  name=stuName placeholder="填写姓名"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</fieldset>
		<fieldset>
				邮箱<input type="email"  name=stuMail placeholder="填写邮箱"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</fieldset>
		<fieldset>
				学校<input type="text"  name=stuSchool placeholder="填写学校"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</fieldset>
		<fieldset>
				电话<input type="text" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" 
					name=stuTelphone title="请输入正确的号码" placeholder="填写联系号码"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</fieldset>
		<fieldset>
				专业<input type="text"  name=stuMajor placeholder="填写专业"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</fieldset>
				<div align="center">
				<input type="submit" value="提交">
				<input type="reset" value="重置"></div>
			</fieldset>
			<input type="hidden" name="completeSudent" value="completeSudent">
		</form>
	</div>
</body>
</html>