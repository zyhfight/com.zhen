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
import po.*;

import service.collectAnswerFunction;
import service.logFunction;
import service.questionFunction;
import service.selecQuestionFunction;

/**
 * Servlet implementation class answerActivityServlet
 */
@WebServlet("/answerActivityServlet")
public class answerActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public answerActivityServlet() {
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
	//	doGet(request, response);
		HttpSession session=request.getSession();
		
		//动作
		String answerActivity=request.getParameter("answerActivity");
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
		logObj.setOperation(answerActivity);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String teaID=session.getAttribute("出题人").toString();
		
		String stemNum=session.getAttribute("问卷题目数").toString();
		int steNo=Integer.parseInt(stemNum);
		for(int i=0;i<steNo;i++)
		{
			String TIDNO=Integer.toString((i+1));
			if(request.getParameter(TIDNO)==null||request.getParameter(TIDNO).equals(""))
			{
				out.println("<script>alert('问卷有题目未选择!');location.href='answerActivity.jsp';</script>");
				return;
			}
		}	
		for(int i=0;i<steNo;i++)
		{
			String sql01="SELECT * FROM SELECTQUESTION WHERE WID='"+session.getAttribute("问卷号")+"'";
//			System.out.println("打印查询选题表sql语句"+sql01);
			
			List<Object>list01=selecQuestionFunction.selectRecord(sql01);
			String TID=((SELECTQUESTION)list01.get(i)).getTID();
			
			String sql1="SELECT * FROM QUESTION WHERE TID='"+TID+"'";
			questionnaireInterface quObj=new questionFunction();
			List<Object>list1=quObj.selectRecord(sql1);
			String type=((question)list1.get(0)).getType();
			System.out.println("打印题目类型"+type);
			
			String WID=session.getAttribute("问卷号").toString();
			String TIDNO=Integer.toString((i+1));
			String student=session.getAttribute("用户名").toString();
			String Activity=session.getAttribute("活动名称").toString();
			
			if(type.equals("danxuan"))
			{
				String answerId=request.getParameter(TIDNO);
				String sql="INSERT INTO collectAnswer(WID,TIDNO,ANSWERID,STUID,ANSWERTIME,TEAID,ACTIVITY)VALUES('";
				sql+=WID+"','"+TIDNO+"','"+answerId+"','"+student+"',"+"NOW()"+",'"+teaID+"','"+Activity+"')";
		
				System.out.println("打印插入答案回收表sql语句"+sql);
				collectAnswerFunction.insertRecord(sql);
//				out.println("<script>alert('问卷已经完成并提交!');location.href='../Login/welcome2.jsp';</script>");
				
			}else if(type.equals("duoxuan"))
			{
				String[] answers=request.getParameterValues(TIDNO);
				for(int j=0;j<answers.length;j++)
				{
					String answerId=answers[j];
					String sql="INSERT INTO collectAnswer(WID,TIDNO,ANSWERID,STUID,ANSWERTIME,TEAID,ACTIVITY)VALUES('";
					sql+=WID+"','"+TIDNO+"','"+answerId+"','"+student+"',"+"NOW()"+",'"+teaID+"','"+Activity+"')";
			
					System.out.println("打印插入答案回收表sql语句"+sql);
					collectAnswerFunction.insertRecord(sql);
//					out.println("<script>alert('问卷已经完成并提交!');location.href='../Login/welcome2.jsp';</script>");
					
				}
			}else
			{
				String answerId=new String(request.getParameter(TIDNO).getBytes("ISO-8859-1"),"UTF-8");
				String sql="INSERT INTO collectAnswer(WID,TIDNO,ANSWERID,STUID,ANSWERTIME,TEAID,ACTIVITY)VALUES('";
				sql+=WID+"','"+TIDNO+"','"+answerId+"','"+student+"',"+"NOW()"+",'"+teaID+"','"+Activity+"')";
				collectAnswerFunction.insertRecord(sql);
				System.out.println("打印插入答案回收表sql语句"+sql);	
			}
		out.println("<script>alert('问卷已经完成并提交!');location.href='../Login/welcome2.jsp';</script>");	
		}
		
	}

}
