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
import service.logFunction;
import service.usrFunction;

/**
 * Servlet implementation class deknightServlet
 */
@WebServlet("/deknightServlet")
public class deknightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deknightServlet() {
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String usrName=new String(request.getParameter("usrName").getBytes("ISO-8859-1"),"UTF-8");
		String csql="SELECT * FROM USR WHERE USRID='"+usrName+"'";
		usrInterface obj=new usrFunction();
		if(obj.checkIdentity(csql)==-1)
		{
			out.println("<script>alert('该用户不存在');location.href='Home.jsp';</script>");
			return;
		}
		
		String sql="UPDATE USR SET IDSTATUS='NORMAL' WHERE USRID='"+usrName+"'";
		usrFunction.updateUsr(sql);
		out.println("<script>alert('解封成功');location.href='deknight.jsp';</script>");
		
				//使用者
				String myusrName=session.getAttribute("用户名").toString();
				//退出时间
				Date date=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String etime=format.format(date);			
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
				logObj.setUsrName(myusrName);
				logObj.setTime(etime);
				logObj.setIpAddress(ipAddress);
				logObj.setOperation("deknight:"+usrName);
				//添加日志信息
				logFunction.insertLog(logObj);
				
	}

}
