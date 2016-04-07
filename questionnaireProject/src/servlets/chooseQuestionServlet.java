package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ServiceInterface.questionnaireInterface;
import po.log;
import service.logFunction;
import service.questionFunction;

/**
 * Servlet implementation class chooseQuestionServlet
 */
@WebServlet("/chooseQuestionServlet")
public class chooseQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chooseQuestionServlet() {
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
		logObj.setOperation("chooseQuestion");
		//添加日志信息
		logFunction.insertLog(logObj);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		int stemNum=Integer.parseInt(session.getAttribute("题目数").toString());
		for(int i=1;i<stemNum;i++)
		{
			for(int j=i+1;j<=stemNum;j++)
			{
				if(request.getParameter(Integer.toString(i)).equals(request.getParameter(Integer.toString(j))))
				{
					out.println("<script>alert('题目有重复项，请重新选择！');location.href='chooseQuestion.jsp';</script>");
					return;
				}
			}
		}
		for(int k=1;k<=stemNum;k++)
		{
			System.out.println("打印题目个数："+stemNum);
			String WID=session.getAttribute("问卷号").toString();
			String TIDNO=Integer.toString(k);
			String TID=request.getParameter(Integer.toString(k));
			System.out.println("打印题目号："+TID);
			String sql="INSERT INTO SELECTQUESTION(WID,TIDNO,TID)VALUES('";
			sql+=WID+"','"+TIDNO+"','"+TID+"')";
			questionnaireInterface quObj=new questionFunction();
			boolean flag=quObj.insertRecord(sql);
			if(!flag)
			{
				out.println("<script>alert('题目信息未能成功插入！');location.href='chooseQuestion.jsp';</script>");
				return;
			}
	//		System.out.println("打印题目号和题目数"+session.getAttribute("题目号").toString()+"---"+session.getAttribute("题目数").toString());
		}
		
		out.println("<script>alert('恭喜，问卷已经组建完成！');location.href='../Login/welcome1.jsp';</script>");
		return;
	}

}
