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

import ServiceInterface.usrInterface;
import po.usr;
import service.logFunction;
import service.userFunction;
import service.usrFunction;

//import service.UsrServe;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		//登陆身份（用户名）
		String usrName=new String(request.getParameter("UsrID").getBytes("ISO-8859-1"),"UTF-8");
		String passWord=request.getParameter("Pwd");
		HttpSession session=request.getSession();
		session.setAttribute("用户名",usrName);
		String sql="SELECT * FROM USR WHERE USRID='"+usrName+"' AND PWD='"+passWord+"'";
		
		
		usrInterface obj=new usrFunction();
		//利用反射机制
		//login()返回1表示“出题人”；返回2表示“答题人”;返回3表示“管理员”
		if(obj.checkIdentity(sql)==-1)
		{
			out.println("<script>alert('用户名或密码错误！请与管理员联系');location.href='Home.jsp';</script>");
			return;
		}
		if(obj.checkIdentity(sql)==1)
		{
			String msql="SELECT * FROM USR WHERE USRID='"+usrName+"'";
			List<Object> list0=new userFunction().selectUser(msql, new usr());
			if(((usr)list0.get(0)).getIDStatus().equals("abnormal"))
			{
				out.println("<script>alert('账号异常！请及时与管理员联系');location.href='Home.jsp';</script>");
				return;
			}
			
			session.setAttribute("身份", "1");
			response.sendRedirect("welcome1.jsp");
			
		}
		else if(obj.checkIdentity(sql)==2)
		{
			String msql="SELECT * FROM USR WHERE USRID='"+usrName+"'";
			List<Object> list0=new userFunction().selectUser(msql, new usr());
			if(((usr)list0.get(0)).getIDStatus().equals("abnormal"))
			{
				out.println("<script>alert('账号异常！请及时与管理员联系');location.href='Home.jsp';</script>");
				return;
			}
			session.setAttribute("身份", "2");
			response.sendRedirect("welcome2.jsp");
			
		}
		else if(obj.checkIdentity(sql)==3)
		{
			session.setAttribute("身份", "3");
			response.sendRedirect("welcome3.jsp");
			
		}
		//登陆动作
		String Login=request.getParameter("Login");
		
		//登陆时间
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		//ip地址
		String ipAddress = null;
		try
		{
			ipAddress=request.getRemoteHost();
//			System.out.println("ip地址："+ipAddress);
		}catch(Exception e){
			e.getMessage();
		}
		String logsql="INSERT INTO LOG(usrName,time,ipAddress,operation)VALUES('";
		logsql+=usrName+"','"+time+"','"+ipAddress+"','"+Login+"')";
//			System.out.println("插入日志表语句"+logsql);
		//添加日志信息
		logFunction.insertLog(logsql);

		
		
	}
}
