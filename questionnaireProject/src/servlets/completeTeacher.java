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
import po.teacher;
import service.logFunction;
import service.shareFunction;

/**
 * Servlet implementation class completeTeacher
 */
@WebServlet("/completeTeacher")
public class completeTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public completeTeacher() {
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
		//doGet(request, response);
		HttpSession session=request.getSession();
		
		//动作
				String completeTeacher=request.getParameter("completeTeacher");
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
				logObj.setOperation(completeTeacher);
				//添加日志信息
				logFunction.insertLog(logObj);
				
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String teaID=session.getAttribute("用户名").toString();
		String teaName=new String(request.getParameter("teaName").getBytes("ISO-8859-1"),"UTF-8");
		String teaMail=new String(request.getParameter("teaMail").getBytes("ISO-8859-1"),"UTF-8");
		String teaTelphone=new String(request.getParameter("teaTelphone").getBytes("ISO-8859-1"),"UTF-8");
		teacher tObj=new teacher();
		tObj.setTeaID(teaID);
		tObj.setTeaMail(teaMail);
		tObj.setTeaName(teaName);
		tObj.setTEATELPHONEL(teaTelphone);
		String sql="INSERT INTO TEACHER(teaID,teaName,teaMail,TEATELPHONEL)VALUES('";
		sql+=teaID+"','"+teaName+"','"+teaMail+"','"+teaTelphone+"')";
//		System.out.println("完善教员信息插入sql语句："+sql);
		shareFunction.insertInformation(sql);
		out.println("<script>alert('信息完善成功');location.href='../Login/welcome1.jsp';</script>");
		session.setAttribute("warning", "欢迎使用问卷系统");
		return;
	}

}
