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

import po.log;
import po.student;
import service.logFunction;
import service.shareFunction;

/**
 * Servlet implementation class completeStudentServlet
 */
@WebServlet("/completeStudentServlet")
public class completeStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public completeStudentServlet() {
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
		String completeSudent=request.getParameter("completeSudent");
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
		logObj.setOperation(completeSudent);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String stuID=session.getAttribute("用户名").toString();
		String stuClass=request.getParameter("stuClass");
		String stuName=new String(request.getParameter("stuName").getBytes("ISO-8859-1"),"UTF-8");
		String stuMail=new String(request.getParameter("stuMail").getBytes("ISO-8859-1"),"UTF-8");
		String stuTelphone=new String(request.getParameter("stuName").getBytes("ISO-8859-1"),"UTF-8");
		String stuMajor=new String(request.getParameter("stuMajor").getBytes("ISO-8859-1"),"UTF-8");
		String stuSchool=new String(request.getParameter("stuSchool").getBytes("ISO-8859-1"),"UTF-8");
		student sObj=new student();
		sObj.setStuClass(stuClass);
		sObj.setStuID(stuID);
		sObj.setStuMail(stuMail);
		sObj.setStuMajor(stuMajor);
		sObj.setStuName(stuName);
		sObj.setStuSchool(stuSchool);
		sObj.setStuTelphone(stuTelphone);
		shareFunction.insertInformation(sObj);
		out.println("<script>alert('信息完善成功');location.href='../Login/welcome2.jsp';</script>");
		session.setAttribute("warning", "欢迎使用问卷系统");
		return;
		
	}

}
