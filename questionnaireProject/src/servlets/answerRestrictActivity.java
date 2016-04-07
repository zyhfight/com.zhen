package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ServiceInterface.questionnaireInterface;
import po.log;
import po.myOption;
import po.myRestrict;
import service.collectAnswerFunction;
import service.logFunction;
import service.optionFunction;
import service.restrictFunction;

/**
 * Servlet implementation class answerRestrictActivity
 */
@WebServlet("/answerRestrictActivity")
public class answerRestrictActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public answerRestrictActivity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		//动作
		String answerRestrictActivity=request.getParameter("answerRestrictActivity");
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
		logObj.setOperation(answerRestrictActivity);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String WID=session.getAttribute("问卷号").toString();
		String stemNo=session.getAttribute("问卷题目数").toString();
		String Activity=session.getAttribute("活动名称").toString();
		//问卷题目数
		int stemNum=Integer.parseInt(stemNo);
		
		int NO=Integer.parseInt(session.getAttribute("题目编号-1").toString());
		
		
		String TID=session.getAttribute("题号").toString();
		
		//题目编号
		int tid=NO+1;
		String TIDNO=Integer.toString(tid);
		//题目类型
		String type=session.getAttribute("题目类型").toString();
		//答题人
		String student=session.getAttribute("用户名").toString();
		//出题人
		String teaID=session.getAttribute("出题人").toString();
		
		
		
		if(type.equals("duoxuan"))
		{
			String[] answers=request.getParameterValues(TIDNO);
			for(int j=0;j<answers.length;j++)
			{
				String answerId=answers[j];
				String sql="INSERT INTO collectAnswer(WID,TIDNO,ANSWERID,STUID,ANSWERTIME,TEAID,ACTIVITY)VALUES('";
				sql+=WID+"','"+TIDNO+"','"+answerId+"','"+student+"',"+"NOW()"+",'"+teaID+"','"+Activity+"')";
				System.out.println("打印插入答案回收表sql语句"+sql);
				collectAnswerFunction.insertRecord(sql);
			}
			if(tid==stemNum||tid>stemNum)
			{
				out.println("<script>alert('问卷已经完成并提交!');location.href='../Login/welcome2.jsp';</script>");
				return;
			}
			session.setAttribute("题目编号-1", tid);
			response.sendRedirect("answerRestrictActivity.jsp");
			return;
		}else if(type.equals("jianda"))
		{
			String answerId=new String(request.getParameter(TIDNO).getBytes("ISO-8859-1"),"UTF-8");
			String sql="INSERT INTO collectAnswer(WID,TIDNO,ANSWERID,STUID,ANSWERTIME,TEAID,ACTIVITY)VALUES('";
			sql+=WID+"','"+TIDNO+"','"+answerId+"','"+student+"',"+"NOW()"+",'"+teaID+"','"+Activity+"')";
			
			
			collectAnswerFunction.insertRecord(sql);
			System.out.println("打印插入答案回收表sql语句"+sql);
			
			if(tid==stemNum||tid>stemNum)
			{
				out.println("<script>alert('问卷已经完成并提交!');location.href='../Login/welcome2.jsp';</script>");
				return;
			}
			
			session.setAttribute("题目编号-1", tid);
			response.sendRedirect("answerRestrictActivity.jsp");
			return;
		}else
		{
			//答案编号
			String answerId=request.getParameter(TIDNO).toString();
			
			String isql="INSERT INTO collectAnswer(WID,TIDNO,ANSWERID,STUID,ANSWERTIME,TEAID,ACTIVITY)VALUES('";
			isql+=WID+"','"+TIDNO+"','"+answerId+"','"+student+"',"+"NOW()"+",'"+teaID+"','"+Activity+"')";
			collectAnswerFunction.insertRecord(isql);
			System.out.println("打印插入答案回收表sql语句"+isql);
			
			if(tid==stemNum||tid>stemNum)
			{
				out.println("<script>alert('问卷已经完成并提交!');location.href='../Login/welcome2.jsp';</script>");
				return;
			}
			
			/*
			 * 关于约束表的操作
			 */
			questionnaireInterface opObj=new optionFunction();
			String sql2="SELECT * FROM MYOPTION WHERE TID='"+TID+"' AND ANSWERID='"+answerId+"'";
			System.out.println("学员查询选项表选项号sql语句："+sql2);
			//选项表list2.size()选项个数
			List<Object>list2=opObj.selectRecord(sql2);
			//选项号
			String optionID=((myOption)list2.get(0)).getOptionID();
			//获取约束表相关信息
			String sql="SELECT * FROM MYRESTRICT WHERE WID='"+WID+"'";
			List<Object>list=restrictFunction.selectRecord(sql);
			
			for(int i=0;i<list.size();i++)
			{
				System.out.println("临界题目编号："+((myRestrict)list.get(i)).getCrisisTID());
				System.out.println("现在题目编号："+TIDNO);
				System.out.println("临界题目编号的选项："+((myRestrict)list.get(i)).getCrisisPID());
				System.out.println("现在选项号："+optionID);
				if(((myRestrict)list.get(i)).getCrisisTID().equals(TIDNO)&&
						((myRestrict)list.get(i)).getCrisisPID().equals(optionID))
				{
					int startTID=Integer.parseInt(((myRestrict)list.get(i)).getStartTID());
					int endTID=Integer.parseInt(((myRestrict)list.get(i)).getEndTID());
					session.setAttribute("题目编号-1", startTID-1);
					session.setAttribute("问卷题目数",endTID);
					response.sendRedirect("answerRestrictActivity.jsp");
					return;
				}
			}
			session.setAttribute("题目编号-1", tid);
			response.sendRedirect("answerRestrictActivity.jsp");
			return;
		}
	}

}
