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
import po.*;
import service.logFunction;

/**
 * Servlet implementation class checklogServlet
 */
@WebServlet("/checklogServlet")
public class checklogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checklogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		if(session.getAttribute("用户名")==null)
		{
			response.sendRedirect("../Login/Home.jsp");
		}
		if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("3"))
		{
			response.sendRedirect("../Login/welcome3.jsp");
			return;
		}
		if(session.getAttribute("身份")!=null&&session.getAttribute("身份").toString().equals("2"))
		{
			response.sendRedirect("../Login/welcome2.jsp");
			return;
		}
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
		String usrName=request.getParameter("usrName");
		String time1=request.getParameter("startTime");
		String time2=request.getParameter("endTime");
//		System.out.print("查询日志表获取的数据"+usrName+"#"+time1+"#"+time2);
		List<Object>list=null;
		if(usrName==""&&time1==""&&time2=="")
		{
			String sql="SELECT * FROM log";
			System.out.println("查询日志表sql语句1："+sql);
			list=logFunction.selectRecord(sql);
		}else if(usrName==""&&time1!=""&&time2=="")
		{
			String startTime=time1.replace('T', ' ');
			String sql="SELECT * FROM log WHERE TIME>'"+startTime+"'";
			System.out.println("查询日志表sql语句2："+sql);
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try{
				if(format.parse(startTime).after(date))
				{
					out.println("<script>alert('开始时间晚于至今');location.href='checklog.jsp';</script>");
					return;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			list=logFunction.selectRecord(sql);
		}else if(usrName==""&&time1==""&&time2!="")
		{
			String endTime=time2.replace('T', ' ');
			String sql="SELECT * FROM log WHERE TIME<'"+endTime+"'";
			System.out.println("查询日志表sql语句3："+sql);
			list=logFunction.selectRecord(sql);
		}else if(usrName==""&&time1!=""&&time2!="")
		{
			String startTime=time1.replace('T', ' ');
			String endTime=time2.replace('T', ' ');
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try{
				if(format.parse(startTime).after(format.parse(endTime)))
				{
					out.println("<script>alert('开始时间晚于结束时间');location.href='checklog.jsp';</script>");
					return;
				}else if(format.parse(startTime).after(date))
				{
					out.println("<script>alert('开始时间晚于至今');location.href='checklog.jsp';</script>");
					return;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			String sql="SELECT * FROM log WHERE TIME<'"+endTime+"' AND TIME>'"+startTime+"'";
			System.out.println("查询日志表sql语句4："+sql);
			list=logFunction.selectRecord(sql);
		}
		else if(usrName!=""&&time1==""&&time2=="")
		{
			usrName=new String(request.getParameter("usrName").getBytes("ISO-8859-1"),"UTF-8");
			String sql="SELECT * FROM log WHERE usrName='"+usrName+"'";
			System.out.println("查询日志表sql语句5："+sql);
			list=logFunction.selectRecord(sql);
		}else if(usrName!=""&&time1!=null&&time2=="")
		{
			usrName=new String(request.getParameter("usrName").getBytes("ISO-8859-1"),"UTF-8");
			String startTime=time1.replace('T', ' ');
			String sql="SELECT * FROM log WHERE usrName='"+usrName+"' AND TIME>'"+startTime+"'";
			System.out.println("查询日志表sql语句6："+sql);
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try{
				if(format.parse(startTime).after(date))
				{
					out.println("<script>alert('开始时间晚于至今');location.href='checklog.jsp';</script>");
					return;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			list=logFunction.selectRecord(sql);
		}else if(usrName!=""&&time1==""&&time2!="")
		{
			usrName=new String(request.getParameter("usrName").getBytes("ISO-8859-1"),"UTF-8");
			String endTime=time2.replace('T', ' ');
			String sql="SELECT * FROM log WHERE usrName='"+usrName+"' AND TIME<'"+endTime+"'";
			System.out.println("查询日志表sql语句7："+sql);
			list=logFunction.selectRecord(sql);
		}else if(usrName!=""&&time1!=""&&time2!="")
		{
			usrName=new String(request.getParameter("usrName").getBytes("ISO-8859-1"),"UTF-8");
			String endTime=time2.replace('T', ' ');
			String startTime=time1.replace('T', ' ');
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try{
				if(format.parse(startTime).after(format.parse(endTime)))
				{
					out.println("<script>alert('开始时间晚于结束时间');location.href='checklog.jsp';</script>");
					return;
				}else if(format.parse(startTime).after(date))
				{
					out.println("<script>alert('开始时间晚于至今');location.href='checklog.jsp';</script>");
					return;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			String sql="SELECT * FROM log WHERE usrName='"+usrName+"' AND TIME<'"+endTime+"' AND TIME>'"+startTime+"'";
			System.out.println("查询日志表sql语句8："+sql);
			list=logFunction.selectRecord(sql);
		}
		//动作
	//	String addActivity=request.getParameter("addActivity");
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
		logObj.setOperation("checklog");
		//添加日志信息
		logFunction.insertLog(logObj);
		
		out.println("<div align=right>");
		out.println("<img src=smiley.gif alt=\"Smiley face\" width=\"32\" height=\"32\">");
		out.println("欢迎您,");
		out.print(session.getAttribute("用户名"));	
		out.println("<input type=button value=bye onclick=\"window.location.href='../share/bye.jsp'\">");
		if(list==null)
		{
			out.println("<script>alert('无日志信息或用户不存在');location.href='checklog.jsp';</script>");
			return;
		}
		out.println("<style type=text/css> body {margin:0;  padding:0;  background-color:#6959CD;}</style>");
		out.println("<div align=center>");
		out.println("<table border=1>");
		out.println("<tr><th>用户名</th><th>操作时间</th><th>ip地址</th><th>操作</th></tr>");
		for(int i=0;i<list.size();i++)
		{
			out.println("<tr><td>");
			out.println(((log)list.get(i)).getUsrName()+"</td>");
			out.println("<td>"+((log)list.get(i)).getTime()+"</td>");
			out.println("<td>"+((log)list.get(i)).getIpAddress()+"</td>");
			out.println("<td>"+((log)list.get(i)).getOperation()+"</td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<br>");
		out.println("<div align=center>");
		out.println("<input type=button value=返回 onclick=\"window.location.href='../Login/welcome3.jsp'\" style=height:40px;width:60px;background-color:#EEC900>");
		out.println("</div>");	
	}

}
