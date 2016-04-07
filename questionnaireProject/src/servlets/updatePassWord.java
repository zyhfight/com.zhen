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
import po.usr;

import service.ModifyPasswordFuntion;
import service.logFunction;

/**
 * Servlet implementation class updatePassWord
 */
@WebServlet("/updatePassWord")
public class updatePassWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePassWord() {
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
				//动作
				String updatePassWord=request.getParameter("updatePassWord");
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
					System.out.println("ip地址："+ipAddress);
				}catch(Exception e){
					e.getMessage();
				}
				log logObj=new log();
				logObj.setUsrName(usrName);
				logObj.setTime(time);
				logObj.setIpAddress(ipAddress);
				logObj.setOperation(updatePassWord);
				//添加日志信息
				logFunction.insertLog(logObj);
		
		
		
		String usrID=session.getAttribute("用户名").toString();
		String oldPassword=request.getParameter("oldPassword");
		String newPassword1=request.getParameter("newPassword1");
		String newPassword2=request.getParameter("newPassword2");
		usr obj=ModifyPasswordFuntion.getUsr(usrID);
		if(obj!=null&&obj.getPwd().equals(oldPassword)&&newPassword1.equals(newPassword2))
		{
			String sql="UPDATE USR SET PWD='"+newPassword1+"'";
			sql+=" WHERE USRID='"+usrID+"'";
	//		System.out.println("修改密码时更新语句"+sql);
			ModifyPasswordFuntion.modifyPassword(sql);
			out.println("<script>alert('密码修改成功，请重新登录');location.href='../Login/Home.jsp';</script>");
			return;
		}
		else
			out.println("<script>alert('密码输入错误或两次输入不一致');location.href='updatePassWord.jsp';</script>");
		return;
	}
}
