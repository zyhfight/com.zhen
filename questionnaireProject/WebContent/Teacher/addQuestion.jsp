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
  		if (validate_required(stem,"请输入题干")==false||
  				validate_required(optionNum,"请输入选项个数")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加题目信息</title>
</head>
<body>
	<div align="center">
		<h1>添加题目信息！</h1>
	
	<form method=post onsubmit="return validate_form(this)" action="addQuestion">
		<fieldset>
		<fieldset>
				输入题干信息：
				<input type="text" name="stem" placeholder="填写题干信息"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</fieldset>		
		<fieldset >
		<div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		题&nbsp;目&nbsp;类&nbsp;型：	
				<input type="radio" name="type" checked="checked" value="danxuan" style="height:20px;width:20px;background-color:#E0EEE0">单选&nbsp;
				<input type="radio" name="type" value="duoxuan" style="height:20px;width:20px;background-color:#E0EEE0">多选&nbsp;
				<input type="radio" name="type" value="jianda" style="height:20px;width:20px;background-color:#E0EEE0">简答
			</div>	
		</fieldset>	
		<fieldset>
		<div align="left">	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		选&nbsp;项&nbsp;个&nbsp;数:
		<input type="number" name="optionNum" min=1 max=9 placeholder="填写选项个数（1-9）"  required  style="height:40px;width:449px;background-color:#E0EEE0">
		</div>		
		</fieldset>	
		
				<input type=submit value="确定">
				<input type="button" value="取消" onclick="window.location.href='../Login/welcome1.jsp'">	
			</fieldset>
		<input type="hidden" name="addQuestion" value="addQuestion">
	</form>
	</div>
</body>
</html>