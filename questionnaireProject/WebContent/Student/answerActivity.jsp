<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ServiceInterface.*" %>
<%@ page import="service.*" %>
<%@ page import="po.*" %>
<%@ page import="java.util.*" %>
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
    background:url(image11.jpg);
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
<title>正在答卷</title>
</head>
<body>
	
	<form action="answerActivity" method="post">
	<fieldset>
	<%
	String sql0="SELECT * FROM QUESTIONNAIRE WHERE WID='"+session.getAttribute("问卷号")+"'";
	questionnaireInterface quennier=new questionnaireFunction();
	List<Object>list0=quennier.selectRecord(sql0);
	session.setAttribute("问卷题目数", ((questionnaire)list0.get(0)).getStemNum());
	session.setAttribute("出题人", ((questionnaire)list0.get(0)).getTeaID());
	
	String sql01="SELECT * FROM SELECTQUESTION WHERE WID='"+session.getAttribute("问卷号")+"'";
	System.out.println("学员查询选题表sql语句："+sql01);
	//查询选题表，每条记录代表一题
	List<Object>list01=selecQuestionFunction.selectRecord(sql01);
	
	questionnaireInterface quObj=new questionFunction();
	questionnaireInterface opObj=new optionFunction();
	questionnaireInterface anObj=new answerFunction();
	
	for(int k=0;k<list01.size();k++)
	{
		String TID=((SELECTQUESTION)list01.get(k)).getTID();
		String TIDNO=((SELECTQUESTION)list01.get(k)).getTIDNO();
		String sql1="SELECT * FROM QUESTION WHERE TID='"+TID+"'";
		//题目表
		List<Object>list1=quObj.selectRecord(sql1);
		out.println(TIDNO+"、"+((question)list1.get(0)).getStem()+"<br>");
		String type=((question)list1.get(0)).getType();
		String sql2="SELECT * FROM MYOPTION WHERE TID='"+TID+"'";
		System.out.println("学员查询选项表sql语句："+sql2);
		List<Object>list2=opObj.selectRecord(sql2);
		if(type.equals("danxuan"))
		{
			for(int j=0;j<list2.size();j++)
			{
				String answerId=((myOption)list2.get(j)).getAnswerID();
				String sql3="SELECT * FROM ANSWER WHERE ANSWERID='"+answerId+"'";
				System.out.println("学员查询答案表sql语句："+sql3);
				List<Object>list3=anObj.selectRecord(sql3);
				out.println("<input type='radio' name="+TIDNO+" value="+answerId+" style=height:20px;width:20px;background-color:#E0EEE0>"+(j+1)+"、"+((answer)list3.get(0)).getContent());
			}
			out.println("<br><br>");
		}
		else if(type.equals("duoxuan"))
		{
			for(int j=0;j<list2.size();j++)
			{
				String answerId=((myOption)list2.get(j)).getAnswerID();
				String sql3="SELECT * FROM ANSWER WHERE ANSWERID='"+answerId+"'";
				System.out.println("学员查询答案表sql语句："+sql3);
				List<Object>list3=anObj.selectRecord(sql3);
				out.println("<input type='checkbox' name="+TIDNO+" id="+(j+1)+" value="+answerId+" style=height:20px;width:20px;background-color:#E0EEE0>"+(j+1)+"、"+((answer)list3.get(0)).getContent());
			}
			out.println("<br><br>");
		}else
		{
			out.println("<input type=text name="+TIDNO+" placeholder=填写简答题答案  required  style=height:40px;width:449px;background-color:#E0EEE0>");
			out.println("<br><br>");
		}
	}

	%>
	<div align="left"><input type="submit" value="提交">
	<input type="button" onclick="window.location.href='../Login/welcome2.jsp'" value="取消"></div>
	<input type="hidden" name="answerActivity" value="answerActivity">
	</fieldset>
	</form>
</body>
</html>