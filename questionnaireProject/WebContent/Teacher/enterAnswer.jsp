<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Session/Session.jsp" %>
<%@ include file="../Session/logOut.jsp" %>
<%@ include file="../Session/Session.jsp" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css"> 
body { 
    margin:0; 
    padding:0; 
    background:url(image9.jpg);
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
  		if (validate_required(answerContent,"请录入答案")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div align="center">
		<form action="enterAnswer" onsubmit="return validate_form(this)" method="post">
		<br>
		<fieldset>	
				<input type="text" name=answerContent placeholder="填写答案信息"  required  style="height:60px;width:449px;background-color:#E0EEE0"> 
				<br/>
				<input type="submit" value="录入答案">
				<input type="button" value="取消" onclick="window.location.href='addOption.jsp'">
		</fieldset>		
			<input type="hidden" name="enterAnswer" value="enterAnswer">
		</form>
	</div>
</body>
</html>