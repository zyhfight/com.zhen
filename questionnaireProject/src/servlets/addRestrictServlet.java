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
import po.myRestrict;
import service.logFunction;
import service.restrictFunction;

/**
 * Servlet implementation class addRestrictServlet
 */
@WebServlet("/addRestrictServlet")
public class addRestrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRestrictServlet() {
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
		String addRestrict=request.getParameter("addRestrict");
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
		logObj.setOperation(addRestrict);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String WID=request.getParameter("WID");
		String crisisTID=request.getParameter("crisisTID");
		int cTID=Integer.parseInt(crisisTID);
		String crisisPID=request.getParameter("crisisPID");
		String startTID=request.getParameter("startTID");
		int sTID=Integer.parseInt(startTID);
		String endTID=request.getParameter("endTID");
		int eTID=Integer.parseInt(endTID);
		if(sTID<=cTID||eTID<=sTID)
		{
			out.println("<script>alert('后面开始编号或结束编号有误！');location.href='addRestrict.jsp';</script>");
			return;
		}
		myRestrict resObj=new myRestrict();
		resObj.setWID(WID);
		resObj.setCrisisTID(crisisTID);
		resObj.setCrisisPID(crisisPID);
		resObj.setStartTID(startTID);
		resObj.setEndTID(endTID);
		boolean flag=restrictFunction.insertRecord(resObj);
		if(!flag)
		{
			out.println("<script>alert('此题该项约束已添加！');location.href='addRestrict.jsp';</script>");
			return;
		}
			
		
		out.println("<script>alert('约束添加成功！');location.href='chooseQuestion.jsp';</script>");
		return;
	}

}
