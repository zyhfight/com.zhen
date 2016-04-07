package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ServiceInterface.questionnaireInterface;
import service.answerFunction;
import service.collectAnswerFunction;
import service.logFunction;
import service.questionFunction;
import service.selecQuestionFunction;
import service.surveyFunction;
import po.*;

/**
 * Servlet implementation class checkActivityServlet
 */
@WebServlet("/checkActivityServlet")
public class checkActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkActivityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		if(session.getAttribute("用户名")==null)
		{
			response.sendRedirect("../Login/Home.jsp");
		}
		if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("3"))
		{
			response.sendRedirect("../Login/welcome3.jsp");
			return;
		}
		if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("2"))
		{
			response.sendRedirect("../Login/welcome2.jsp");
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("用户名")==null)
		{
			response.sendRedirect("../Login/Home.jsp");
		}
		if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("3"))
		{
			response.sendRedirect("../Login/welcome3.jsp");
			return;
		}
		if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("2"))
		{
			response.sendRedirect("../Login/welcome2.jsp");
			return;
		}
		//动作
		String checkResult=request.getParameter("checkResult");
		//使用者
		String usrName=session.getAttribute("用户名").toString();
		//退出时间
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);			
		//退出时ip地址
		String ipAddress = null;
		try
		{
			ipAddress=request.getRemoteHost();
		//	System.out.println("ip地址："+ipAddress);
		}catch(Exception e){
			e.getMessage();
		}
		log logObj=new log();
		logObj.setUsrName(usrName);
		logObj.setTime(time);
		logObj.setIpAddress(ipAddress);
		logObj.setOperation(checkResult);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<div align=right>");
		out.println("<img src=smiley.gif alt=\"Smiley face\" width=\"32\" height=\"32\">");
		out.println("欢迎您,");
		out.print(session.getAttribute("用户名"));	
		out.println("<input type=button value=bye onclick=\"window.location.href='../share/bye.jsp'\">");
//		System.out.println("我的测试");
		
		String activity=new String(request.getParameter("Activity").getBytes("ISO-8859-1"),"UTF-8");

		
		//自己输入活动、时间形式
		String myTime=request.getParameter("ptime");
		String sql0=null;
		System.out.println(myTime);
		if(myTime=="");
		{
			sql0="SELECT * FROM SURVEY WHERE TEAID='"+session.getAttribute("用户名").toString();
			sql0+="' AND ACTIVITY='"+activity+"'";
		}
		if(myTime!="")
		{
			sql0="SELECT * FROM SURVEY WHERE TEAID='"+session.getAttribute("用户名").toString();
			sql0+="' AND ACTIVITY='"+activity+"' AND STARTTIME LIKE '%"+myTime+"%'";
		}
		
		
/*	
 * 下拉选项形式查看；某活动从最初到至今都显示。	
		session.setAttribute("查看活动名称", activity);
//		System.out.println("要查看活动名称"+activity);
//		String activity=session.getAttribute("查看活动名称").toString();
		String sql0="SELECT * FROM SURVEY WHERE TEAID='"+session.getAttribute("用户名").toString();
		sql0+="' AND ACTIVITY='"+activity+"'";
		
*/		
		
		List<Object>list0=surveyFunction.selectRecord(sql0);
		if(list0==null)
		{
			out.println("<script>alert('无信息或您输入数据有误！');location.href='checkRsult.jsp';</script>");
			return;
		}
		
		String myActivity=((survey)list0.get(0)).getACTIVITY();
		Set<String> mySet=new HashSet<>();
		for(int j=0;j<list0.size();j++)
		{
			mySet.add(((survey)list0.get(j)).getWID());
		}
		out.println("<div align=center><h1>活动名称："+activity+"<h1></div><br>");
		for(String str:mySet)
		{
			
			
			String WID=str;
			
			String sql1="SELECT * FROM collectAnswer WHERE TEAID='"+session.getAttribute("用户名").toString()+"'";
			sql1+=" AND WID='"+WID+"' AND ACTIVITY='"+myActivity+"'";
//			System.out.println("查询答案回收表sql语句"+sql1);
			List<Object>list1=collectAnswerFunction.selectRecord(sql1);
			if(list1==null)
			{
				out.println("<script>alert('暂时无人参与活动反馈');location.href='../Login/welcome1.jsp';</script>");
				return;
			}
			out.println("<style type=text/css> body {margin:0;  padding:0;  background-color:#6959CD;}</style>");
			out.println("<div align=center>");
			out.println("<table border=1>");
			out.println("<tr><th>题干信息</th><th>选择的答案</th><th>答题人</th><th>答题时间</th></tr>");
			for(int j=0;j<list1.size();j++)
			{
				String sql02="SELECT * FROM SELECTQUESTION WHERE WID='"+WID+"' AND TIDNO='";
				sql02+=((collectAnswer)list1.get(j)).getTIDNO()+"'";
				List<Object>list02=selecQuestionFunction.selectRecord(sql02);
				String TID=((SELECTQUESTION)list02.get(0)).getTID();
				
				String sql2="SELECT * FROM QUESTION WHERE TID='"+TID+"'";

		//		System.out.println("查询题目表sql语句"+sql2);
				questionnaireInterface quObj=new questionFunction();
				List<Object>list2=quObj.selectRecord(sql2);
				
				//题目类型
				String type=((question)list2.get(0)).getType();
				
				out.println("<tr>");
				//题干
				out.println("<td>"+((collectAnswer)list1.get(j)).getTIDNO()+"、"+((question)list2.get(0)).getStem()+"</td>");
				if(type.equals("jianda"))
				{
					out.println("<td>");
			//		out.println("活动名称:"+((collectAnswer)list1.get(j)).getACTIVITY()+"</td>");
					out.println(((collectAnswer)list1.get(j)).getANSWERID()+"</td>");
					out.println("<td>"+((collectAnswer)list1.get(j)).getSTUID()+"</td>");
					out.println("<td>"+((collectAnswer)list1.get(j)).getANSWERTIME()+"</td>");
					out.println("</tr>");
				}else
				{
					String sql3="SELECT * FROM ANSWER WHERE ANSWERID='"+((collectAnswer)list1.get(j)).getANSWERID()+"'";
		    		questionnaireInterface anObj=new answerFunction();
		    		List<Object>list3=anObj.selectRecord(sql3);
		    		out.println("<td>");
		    		out.println(((answer)list3.get(0)).getContent()+"</td>");
		    		out.println("<td>"+((collectAnswer)list1.get(j)).getSTUID()+"</td>");
		    		out.println("<td>"+((collectAnswer)list1.get(j)).getANSWERTIME()+"</td>");
		    		out.println("</td></tr>");
				}
			}	
			out.println("</table>");
			out.println("</div>");
			out.println("<br>");
			
		}
		out.println("<div align=center>");
		out.println("<input type=button value=返回 onclick=\"window.location.href='../Login/welcome3.jsp'\" style=height:40px;width:60px;background-color:#EEC900>");
		out.println("</div>");
/*		if(activity!=null)
		{
			out.println("<script>alert('查看调查结果');location.href='ActivityResult.jsp';</script>");
			return;
		}*/
		
	}

}
