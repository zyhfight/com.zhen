<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="po.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<%@ page import="ServiceInterface.*" %>
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
    background:url(image4.jpg);
    background-size:cover;
} 
fieldset { 
    border:none; 
    padding:10px 10px 0; 
} 
fieldset input[type=text] { 
    background:url(style/default/images/user.png) 4px 5px no-repeat; 
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
  		if (validate_required(Activity,"请输入活动名称")==false||
  				validate_required(endTime,"请输入问卷结束时间")==false||
  				validate_required(group,"请选择发布人群")==false)
   		 {
  			return false
  		}
  		}
}
</script>
<style type="text/css">
<!--
a {text-transform:none;text-decoration:none;} 
a:hover {text-decoration:underline} 
-->
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增活动</title>
</head>
<body>
	<div align="center">
	<div align="left"><a href="addSymbol.jsp" style="font-weight: bold; font-size:20px;background-color:#CD00CD ">添加人群样本</a><br /></div>
		<%
		int flag=0;
		String sql0="SELECT * FROM QUESTIONNAIRE WHERE TEAID='"+session.getAttribute("用户名")+"'";
//		System.out.println("查询问卷表sql语句："+sql0);
		questionnaireInterface quennier=new questionnaireFunction();
		List<Object>list0=quennier.selectRecord(sql0);
		if(list0==null)
		{
			out.println("<script>alert('无问卷信息，请新建问卷！');location.href='addQuestionnaire.jsp';</script>");
			return;
		}
		for(int i=0;i<list0.size();i++)
		{
			flag=0;
			int stemNum=Integer.parseInt(((questionnaire)list0.get(i)).getStemNum());
//			System.out.println("问卷题目个数"+stemNum);
			String WID=((questionnaire)list0.get(i)).getWID();
//			System.out.println("发布活动时验证问卷号"+WID);
			String sql01="SELECT * FROM SELECTQUESTION WHERE WID='"+WID+"'";
			List<Object>list01=selecQuestionFunction.selectRecord(sql01);
			if(list01==null)
			{
				String desql0="DELETE FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
				System.out.println("删除问卷表sql语句："+desql0);
				new questionnaireFunction().deleteRecord(desql0);
				String deSurvey="DELETE FROM SURVEY WHERE WID='"+WID+"'";
				System.out.println("删除调查表sql语句："+deSurvey);
				surveyFunction.deleteRecord(deSurvey);
				String deRestrict="DELETE FROM MYRESTRICT WHERE WID='"+WID+"'";
				System.out.println("删除约束表sql语句："+deSurvey);
				restrictFunction.deleteRecord(deRestrict);
				flag=1;
			}
			else if(list01.size()!=stemNum)
			{
				for(int k=0;k<list01.size();k++)
				{
					String TID=((SELECTQUESTION)list01.get(k)).getTID();
					String sql1="SELECT * FROM QUESTION WHERE TID='"+TID+"'";
					questionnaireInterface quObj=new questionFunction();
					questionnaireInterface opObj=new optionFunction();
					//题目记录
					List<Object>list1=quObj.selectRecord(sql1);
					if(list1==null)
					{
						String daql01="DELETE FROM SELECTQUESTION WHERE WID='"+WID+"'";
						System.out.println("删除选题表sql语句："+daql01);
						selecQuestionFunction.deleteRecord(daql01);
						String desql0="DELETE FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
						System.out.println("删除问卷表sql语句："+desql0);
						new questionnaireFunction().deleteRecord(desql0);
						String deSurvey="DELETE FROM SURVEY WHERE WID='"+WID+"'";
						System.out.println("删除调查表sql语句："+deSurvey);
						surveyFunction.deleteRecord(deSurvey);
						String deRestrict="DELETE FROM MYRESTRICT WHERE WID='"+WID+"'";
						System.out.println("删除约束表sql语句："+deSurvey);
						restrictFunction.deleteRecord(deRestrict);
						flag=1;
					}
					else{
						String onptionNum=((question)list1.get(0)).getOptionNum();
						String sql2="SELECT * FROM MYOPTION WHERE TID='"+TID+"'";
//						System.out.println("查询选项表sql语句："+sql2);
						List<Object>list2=opObj.selectRecord(sql2);
						if(list2==null)
						{
							String desql1="DELETE FROM QUESTION WHERE TID='"+TID+"'";
							System.out.println("删除题目表sql语句："+desql1);
							new questionFunction().deleteRecord(desql1);
							String daql01="DELETE FROM SELECTQUESTION WHERE WID='"+WID+"'";
							System.out.println("删除选题表sql语句："+daql01);
							selecQuestionFunction.deleteRecord(daql01);
							String desql0="DELETE FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
							System.out.println("删除问卷表sql语句："+desql0);
							new questionnaireFunction().deleteRecord(desql0);
							String deSurvey="DELETE FROM SURVEY WHERE WID='"+WID+"'";
							System.out.println("删除调查表sql语句："+deSurvey);
							surveyFunction.deleteRecord(deSurvey);
							String deRestrict="DELETE FROM MYRESTRICT WHERE WID='"+WID+"'";
							System.out.println("删除约束表sql语句："+deSurvey);
							restrictFunction.deleteRecord(deRestrict);
							flag=1;
						}else {
							String desql2="DELETE FROM MYOPTION WHERE TID='"+TID+"'";
							System.out.println("删除选项表sql语句："+desql2);
							new optionFunction().deleteRecord(desql2);
							String desql1="DELETE FROM QUESTION WHERE TID='"+TID+"'";
							System.out.println("删除题目表sql语句："+desql1);
							new questionFunction().deleteRecord(desql1);
							String daql01="DELETE FROM SELECTQUESTION WHERE WID='"+WID+"'";
							System.out.println("删除选题表sql语句："+daql01);
							String desql0="DELETE FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
							System.out.println("删除问卷表sql语句："+desql0);
							new questionnaireFunction().deleteRecord(desql0);
							String deSurvey="DELETE FROM SURVEY WHERE WID='"+WID+"'";
							System.out.println("删除调查表sql语句："+deSurvey);
							surveyFunction.deleteRecord(deSurvey);
							String deRestrict="DELETE FROM MYRESTRICT WHERE WID='"+WID+"'";
							System.out.println("删除约束表sql语句："+deSurvey);
							restrictFunction.deleteRecord(deRestrict);
							flag=1;
						}
					}
						
				}
			}else{
					for(int k=0;k<list01.size();k++)
					{
						String TID=((SELECTQUESTION)list01.get(k)).getTID();
						String sql1="SELECT * FROM QUESTION WHERE TID='"+TID+"'";
						System.out.println("查询题目表sql语句："+sql1);
						questionnaireInterface quObj=new questionFunction();
						questionnaireInterface opObj=new optionFunction();
						//题目记录
						List<Object>list1=quObj.selectRecord(sql1);
						if(list1==null)
						{
							String daql01="DELETE FROM SELECTQUESTION WHERE WID='"+WID+"'";
							System.out.println("删除选题表sql语句："+daql01);
							selecQuestionFunction.deleteRecord(daql01);
							String desql0="DELETE FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
							System.out.println("删除问卷表sql语句："+desql0);
							new questionnaireFunction().deleteRecord(desql0);
							String deSurvey="DELETE FROM SURVEY WHERE WID='"+WID+"'";
							System.out.println("删除调查表sql语句："+deSurvey);
							surveyFunction.deleteRecord(deSurvey);
							String deRestrict="DELETE FROM MYRESTRICT WHERE WID='"+WID+"'";
							System.out.println("删除约束表sql语句："+deSurvey);
							restrictFunction.deleteRecord(deRestrict);
							flag=1;
							
						}else
						{
							String onptionNum=((question)list1.get(0)).getOptionNum();
							String sql2="SELECT * FROM MYOPTION WHERE TID='"+TID+"'";
//							System.out.println("查询选项表sql语句："+sql2);
							List<Object>list2=opObj.selectRecord(sql2);
							if(list2==null)
							{
								String desql1="DELETE FROM QUESTION WHERE TID='"+TID+"'";
								System.out.println("删除题目表sql语句："+desql1);
								new questionFunction().deleteRecord(desql1);
								String daql01="DELETE FROM SELECTQUESTION WHERE WID='"+WID+"'";
								System.out.println("删除选题表sql语句："+daql01);
								selecQuestionFunction.deleteRecord(daql01);
								String desql0="DELETE FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
								System.out.println("删除问卷表sql语句："+desql0);
								new questionnaireFunction().deleteRecord(desql0);
								String deSurvey="DELETE FROM SURVEY WHERE WID='"+WID+"'";
								System.out.println("删除调查表sql语句："+deSurvey);
								surveyFunction.deleteRecord(deSurvey);
								String deRestrict="DELETE FROM MYRESTRICT WHERE WID='"+WID+"'";
								System.out.println("删除约束表sql语句："+deSurvey);
								restrictFunction.deleteRecord(deRestrict);
								flag=1;
								
							}else if(list2.size()!=Integer.parseInt(onptionNum)){
								
									String desql2="DELETE FROM MYOPTION WHERE TID='"+TID+"'";
									System.out.println("删除选项表sql语句："+desql2);
									new optionFunction().deleteRecord(desql2);
									String desql1="DELETE FROM QUESTION WHERE TID='"+TID+"'";
									System.out.println("删除题目表sql语句："+desql1);
									new questionFunction().deleteRecord(desql1);
									String daql01="DELETE FROM SELECTQUESTION WHERE WID='"+WID+"'";
									System.out.println("删除选题表sql语句："+daql01);
									selecQuestionFunction.deleteRecord(daql01);
									String desql0="DELETE FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
									System.out.println("删除问卷表sql语句："+desql0);
									new questionnaireFunction().deleteRecord(desql0);
									String deSurvey="DELETE FROM SURVEY WHERE WID='"+WID+"'";
									System.out.println("删除调查表sql语句："+deSurvey);
									surveyFunction.deleteRecord(deSurvey);
									String deRestrict="DELETE FROM MYRESTRICT WHERE WID='"+WID+"'";
									System.out.println("删除约束表sql语句："+deSurvey);
									restrictFunction.deleteRecord(deRestrict);
									flag=1;
								
							}
								
						}		
			}
		}
	}	
		%>
	<form method="post" onsubmit="return validate_form(this)" action="addActivity">
	    	<br><br><br><br><br><br>
	    	<fieldset>
	    	<legend style="font-weight:bold;font-size: 20px;color:#00FF00">新增活动</legend>
			<fieldset>
			
			<label style="font-weight:bold">
				活动名称：
				<input type=text name="Activity"  style="height:40px;width:449px;background-color:#E0EEE0">
			</label>
			
			</fieldset>
			
			<fieldset>
			<label style="font-weight:bold">	
				选择问卷：
				<%
				String teaId=session.getAttribute("用户名").toString();
				String sql="SELECT * FROM QUESTIONNAIRE WHERE TEAID='"+teaId+"'";
			//	System.out.println("查询问卷表的sql语句"+sql);
				List<Object>list=selectRecord.selectQuetionnaireTable(sql);
				if(list==null)
				{
					out.println("<script>alert('无问卷信息，请新建问卷！');location.href='addQuestionnaire.jsp';</script>");
					return;
				}
				out.println("<script>alert('请输入活动名称');</script>");
				out.println("<select name=WID style=height:40px;width:449px;background-color:#E0EEE0>");
				for(int j=0;j<list.size();j++)
				{
					out.println("<option value="+(((questionnaire)list.get(j)).getWID())+">"+((questionnaire)list.get(j)).getSubject()+"</option>");
				}
				out.println("</select>");
				%>	
			</label>
			</fieldset>
			<fieldset>
			<label style="font-weight:bold">
				发布人群：
				<%
				String syteaId=session.getAttribute("用户名").toString();
				String sysql="SELECT * FROM SYMBOL WHERE TEAID='"+syteaId+"'";
			//	System.out.println("查询样本表的sql语句"+sysql);
				List<Object>sylist=new symbolFunction().selectRecord(sysql);
				if(sylist==null)
				{
					out.println("<script>alert('无样本信息，请添加样本！');location.href='addSymbol.jsp';</script>");
					return;
				}
				out.println("<select name=group style=height:40px;width:449px;background-color:#E0EEE0>");
				for(int k=0;k<sylist.size();k++)
				{
					out.println("<option value="+(((symbol)sylist.get(k)).getFEATURE())+">"+((symbol)sylist.get(k)).getFEATURE()+"</option>");
				}
				out.println("</select>");
				%>	
			</label>
			</fieldset>
			<fieldset>
			<label style="font-weight:bold">结束时间：
				<input type="datetime-local" name="endTime" style=height:40px;width:449px;background-color:#E0EEE0>
			</label>
			</fieldset>
			<label>
				<input type=submit value="发布" style=height:30px;width:100px>
				<input type="button" value="取消" onclick="window.location.href='../Login/welcome1.jsp'">
			</label>
		</fieldset>
		<input type="hidden" name="addActivity" value="addActivity">
	</form>
	</div>
</body>
</html>