<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/check1.jsp" %>
<%@ page import="service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="po.*" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css"> 
body { 
    margin:0; 
    padding:0; 
     background:url(image7.jpg);
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
  		if (validate_required(Activity,"请输入活动名称")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看发布活动结果</title>
</head>
<body>
	<%
		String sql0="SELECT * FROM SURVEY WHERE TEAID='"+session.getAttribute("用户名").toString()+"'";
	    List<Object>list0=surveyFunction.selectRecord(sql0);
	    if(list0==null)
	    {
	    	out.println("<script>alert('您尚未发布任何活动！');location.href='../Login/welcome1.jsp';</script>");
			return;
	    }
	    
	%>
	<div align="center">
		<h4>查看活动结果</h4>
		<form method='post' onsubmit="return validate_form(this)" action="checkResult">
		<fieldset>
		<table  border=1>
			<tr>
				<td>查看活动名：</td>
				<td>
					<input type="text" name=Activity placeholder="填写活动名称"  required  style="height:40px;width:449px;background-color:#E0EEE0">
				<%
				//下拉选项框形式
			/*	out.println("<select name=Activity placeholder=填写活动名称  required  style=height:40px;width:449px;background-color:#E0EEE0>");
				for(int i=0;i<list0.size();i++)
				{
					
					out.println("<option value="+((survey)list0.get(i)).getACTIVITY()+">");
					out.println(((survey)list0.get(i)).getACTIVITY());
				}*/
				%></td>
				
				<tr>
				<td>活动发布时间</td>
				<td><input type="date" name=ptime style="height:40px;width:449px;background-color:#E0EEE0"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type=submit value="确定"  style="height:30px;">
				<input type="button" value="取消" onclick="window.location.href='../Login/welcome1.jsp'" style="height:30px;"></td>
			</tr>
		</table>
		<input type="hidden" name="checkResult" value="checkResult">
		</fieldset>
	</form>
	</div>
</body>
</html>