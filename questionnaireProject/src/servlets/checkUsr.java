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

import po.log;
import po.usr;
import service.logFunction;
import service.usrFunction;

/**
 * Servlet implementation class checkUsr
 */
@WebServlet("/checkUsr")
public class checkUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkUsr() {
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
		String checkUsr=request.getParameter("checkUsr");
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
		logObj.setOperation(checkUsr);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String usrID=new String(request.getParameter("UsrID").getBytes("ISO-8859-1"),"UTF-8");
		String sql="SELECT * FROM USR WHERE USRID='"+usrID+"'";
		List<Object>list=new usrFunction().selectUsr(sql);
		if(list==null)
		{
			out.println("<script>alert('输入的用户不存在！');location.href='checkUsr.jsp';</script>");
			return;
		}
		session.setAttribute("查看身份", ((usr)list.get(0)).getIdentity());
		session.setAttribute("查看用户名", ((usr)list.get(0)).getUsrID());
		session.setAttribute("密码", ((usr)list.get(0)).getPwd());
		session.setAttribute("账号状态", ((usr)list.get(0)).getIDStatus());
		response.sendRedirect("checkUsr.jsp");
	}

}
