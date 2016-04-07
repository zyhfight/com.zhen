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
import service.optionFunction;

/**
 * Servlet implementation class addOptionServlet
 */
@WebServlet("/addOptionServlet")
public class addOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOptionServlet() {
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
		String addOption=request.getParameter("addOption");
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
		logObj.setOperation(addOption);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		int optionNo=Integer.parseInt(session.getAttribute("选项个数").toString());
		for(int i=1;i<optionNo;i++)
		{
			for(int j=i+1;j<=optionNo;j++)
			{
				if(request.getParameter(Integer.toString(i)).equals(request.getParameter(Integer.toString(j))))
				{
					out.println("<script>alert('选项有重复项，请重新选择！');location.href='addOption.jsp';</script>");
					return;
				}
			}
		}
		for(int k=1;k<=optionNo;k++)
		{
			System.out.println("打印选项个数："+optionNo);
			
			String TID=session.getAttribute("题号").toString();
//			System.out.println("打印题目号："+TID);
			String optionID=Integer.toString(k);
//			System.out.println("打印选项编号："+optionID);
			String answerID=request.getParameter(Integer.toString(k));
//			System.out.println("打印答案编号："+answerID);
			String sql="INSERT INTO MYOPTION(TID,optionID,answerID)VALUES('";
			sql+=TID+"','"+optionID+"','"+answerID+"')";
			System.out.println("插入选项表的sql语句"+sql);
			questionnaireInterface opObj=new optionFunction();
			boolean flag=opObj.insertRecord(sql);
			if(!flag)
			{
				out.println("<script>alert('选项信息未能成功插入！');location.href='addOption.jsp';</script>");
				return;
			}
	//		System.out.println("打印题目号和题目数"+session.getAttribute("题目号").toString()+"---"+session.getAttribute("题目数").toString());
		}
		
		out.println("<script>alert('选项信息添加成功');location.href='chooseQuestion.jsp';</script>");
		return;
	}

}
