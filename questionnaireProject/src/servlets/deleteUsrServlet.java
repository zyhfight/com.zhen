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

import ServiceInterface.userInterface;
import ServiceInterface.usrInterface;
import po.*;
import service.*;


/**
 * Servlet implementation class deleteUsr
 */
@WebServlet("/deleteUsr")
public class deleteUsrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUsrServlet() {
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
		String deleteUsr=request.getParameter("deleteUsr");
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
		logObj.setOperation(deleteUsr);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String UsrID=new String(request.getParameter("UsrID").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("要删除的用户名："+UsrID+"--");
		
		userInterface userObj=new userFunction();
		usrInterface usrObj=new usrFunction();
		usrInterface obj=new usrFunction();
		
		
		String dsql="SELECT * FROM USR WHERE USRID='"+usrName+"'";
		
		if(obj.checkIdentity(dsql)==-1)
		{
			out.println("<script>alert('要删除用户不存在或用户名输入有误');location.href='deleteUsr.jsp';</script>");
			return;
		}
		
		//删除教员
		if(obj.checkIdentity(dsql)==1)
		{
			String sql="SELECT * FROM TEACHER WHERE TEAID='"+UsrID+"'";
			List<Object>userlist=userObj.selectUser(sql,new teacher());
			String usrSql="SELECT * FROM Usr WHERE usrID='"+UsrID+"'";
			if(userlist!=null)
			{
				sql="DELETE FROM teacher WHERE TEAID='"+UsrID+"'";
				userObj.deleteUser(sql);
				sql="DELETE FROM Usr WHERE UsrID='"+UsrID+"'";
				usrObj.deleteUsr(sql);
				out.println("<script>alert('删除成功');location.href='deleteUsr.jsp';</script>");
				return;
			}
			else if(usrObj.checkIdentity(usrSql)!=-1)
			{
				sql="DELETE FROM Usr WHERE UsrID='"+UsrID+"'";
				usrObj.deleteUsr(sql);
				out.println("<script>alert('删除成功');location.href='deleteUsr.jsp';</script>");
				return;
			}
		}
		//删除学员
		else if(obj.checkIdentity(dsql)==2)
		{
			String sql="SELECT * FROM student WHERE stuID='"+UsrID+"'";
			String usrSql="SELECT * FROM Usr WHERE usrID='"+UsrID+"'";
			List<Object>userlist=userObj.selectUser(sql,new teacher());
			if(userlist!=null)
			{
				sql="DELETE FROM student WHERE stuID='"+UsrID+"'";
				userObj.deleteUser(sql);
				sql="DELETE FROM Usr WHERE UsrID='"+UsrID+"'";
				usrObj.deleteUsr(sql);
				out.println("<script>alert('删除成功');location.href='deleteUsr.jsp';</script>");
				return;
			}
			else if(usrObj.checkIdentity(usrSql)!=-1)
			{
				sql="DELETE FROM Usr WHERE UsrID='"+UsrID+"'";
				usrObj.deleteUsr(sql);
				out.println("<script>alert('删除成功');location.href='deleteUsr.jsp';</script>");
				return;
			}
		}
		else
		{
			out.println("<script>alert('要删除用户不存在或用户名输入有误');location.href='deleteUsr.jsp';</script>");
			return;
		}
	}

}
