<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    background-color:#E4E8EC; 
    
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
  		if (validate_required(crisisTID,"请输入临界题目编号")==false||
  				validate_required(crisisPID,"请输入临界题目选项编号")==false||
  				validate_required(startPID,"请输入后面要答的题目编号")==false||
  				validate_required(endPID,"请输入后面要答的题目编号")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加约束条件</title>
</head>
<body>
	<form action="addRestrict" onsubmit="return validate_form(this)" method="post">
		<fieldset>
			<legend style="font-weight: bold">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;添加约束条件</legend>
		<fieldset>
		<%
			if(session.getAttribute("题目数")==null)
				out.println("<script>alert('信息有误');location.href='addOption.jsp';</script>");
		
		%>	
				临界题目编号:&nbsp;&nbsp;&nbsp;
				<input type="number" name="crisisTID" min="1" max=
				<%=Integer.parseInt(session.getAttribute("题目数").toString())%> 
				placeholder="临界题目编号"  required  style="height:40px;width:430px;background-color:#E0EEE0">
		</fieldset>	
		<fieldset>
				题目选项编号:&nbsp;&nbsp;&nbsp;
				<input type="number" name=crisisPID min="1" max=4
				placeholder="临界题目的选项号"  required  style="height:40px;width:430px;background-color:#E0EEE0">
		</fieldset>
		<fieldset>	
				后面要答的题目编号:
				<input type="number" name="startTID" 
				placeholder="后面要答的起始题目编号"  required  style="height:40px;width:200px;background-color:#E0EEE0"> - <input type="number" name=endTID max=<%=Integer.parseInt(session.getAttribute("题目数").toString())%>
				placeholder="后面要答的结束题目编号"  required  style="height:40px;width:200px;background-color:#E0EEE0">
		</fieldset>	
		<fieldset>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="添加约束">
			<input value="取消" type="button" onclick="window.location.href='chooseQuestion.jsp'">
			
		</fieldset>
		<input type="hidden" name="WID" value="<%=session.getAttribute("问卷号")%>">
		<input type="hidden" name="addRestrict" value="addRestrict">
		</fieldset>
	</form>
</body>
</html>