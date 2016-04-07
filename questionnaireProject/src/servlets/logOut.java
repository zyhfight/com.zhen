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
import service.logFunction;

/**
 * Servlet implementation class logOut
 */
@WebServlet("/logOut")
public class logOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logOut() {
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		//退出动作
		String logout=request.getParameter("logout");
		
		//退出者身份（用户名）
		if(session.getAttribute("用户名")==null)
		{
			out.println("<script>alert('请登录!');location.href='../Login/Home.jsp';</script>");
			return;
		}
		String usrName=session.getAttribute("用户名").toString();
		//退出时间
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);			
		//退出时ip地址
	//	InetAddress addr = InetAddress.getLocalHost();
	//	String ipAddress=addr.getHostAddress();//获得本机IP
		String ipAddress = null;
		try
		{
			ipAddress=request.getRemoteHost();
			System.out.println("ip地址："+ipAddress);
		}catch(Exception e){
			e.getMessage();
		}
//		System.out.println("ip地址："+ipAddress);
		//添加log信息
		log logObj=new log();
		logObj.setUsrName(usrName);
		logObj.setTime(time);
		logObj.setIpAddress(ipAddress);
		logObj.setOperation(logout);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		if(logout!=null&&logout.equals("logout"))
		{
			session.removeAttribute("用户名");
			response.sendRedirect("../Login/Home.jsp");
			return;
		}
	}

}
