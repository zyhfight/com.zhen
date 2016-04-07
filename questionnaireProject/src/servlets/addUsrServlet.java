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

import ServiceInterface.usrInterface;
import po.log;
import po.usr;
import service.logFunction;
import service.usrFunction;

/**
 * Servlet implementation class addUsrServlet
 */
@WebServlet("/addUsrServlet")
public class addUsrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUsrServlet() {
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
		String addUsr=request.getParameter("addUsr");
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
		logObj.setOperation(addUsr);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String UsrID=new String(request.getParameter("UsrID").getBytes("ISO-8859-1"),"UTF-8");
		String Pwd=request.getParameter("Pwd");
		String Identity=request.getParameter("Identity");
		String Pwd1=request.getParameter("Pwd1");
		usrInterface obj=new usrFunction();
		String sql="SELECT * FROM USR WHERE USRID='"+UsrID+"'";
//		System.out.println("验证身份的Sql语句："+obj.checkIdentity(sql));
//		System.out.println("验证身份后的返回值："+obj.checkIdentity(sql));
		/*
		 * 验证用户名和密码
		 */
		if((obj.checkIdentity(sql)!=(-1)))
		{
			out.println("<script>alert('用户名已存在');location.href='addUsr.jsp';</script>");
			return;
		}
		if(!Pwd.equals(Pwd1))
		{
			out.println("<script>alert('密码输入不一致');location.href='addUsr.jsp';</script>");
			return;
		}
		/*
		 * 增加用户
		 */
		usr usrObj=new usr();
		usrObj.setUsrID(UsrID);
		usrObj.setPwd(Pwd);
		usrObj.setIdentity(Identity);
		usrObj.setIDStatus("NORMAL");
		if(obj.addUsr(usrObj))
		{
			out.println("<script>alert('添加用户成功!');location.href='addUsr.jsp';</script>");
		}
		
	}

}
