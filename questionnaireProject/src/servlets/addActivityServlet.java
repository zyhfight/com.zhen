package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.log;
import po.survey;
import service.logFunction;
import service.surveyFunction;

/**
 * Servlet implementation class addActivityServlet
 */
@WebServlet("/addActivityServlet")
public class addActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addActivityServlet() {
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
		String addActivity=request.getParameter("addActivity");
		//使用者
		String usrName=session.getAttribute("用户名").toString();
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
		logObj.setUsrName(usrName);
		logObj.setTime(etime);
		logObj.setIpAddress(ipAddress);
		logObj.setOperation(addActivity);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String Activity=new String(request.getParameter("Activity").getBytes("ISO-8859-1"),"UTF-8");
		String WID=request.getParameter("WID");
		System.out.println("新增活动时获取的问卷号："+WID);
		String group=new String(request.getParameter("group").getBytes("ISO-8859-1"),"UTF-8");
		String endTime=request.getParameter("endTime");
		
		if(endTime=="")
		{
			out.println("<script>alert('请输入问卷结束时间');location.href='addActivity.jsp';</script>");
			return;
		}
		
		
		String teaID=session.getAttribute("用户名").toString();
		Date time=new Date();
		endTime=endTime.replace("T", " ");
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			Date mydate=dateFormat.parse(endTime);
			if(mydate.before(time))
			{
				out.println("<script>alert('时间输入错误(结束时间早于发布时间)');location.href='addActivity.jsp';</script>");
				return;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String startTime=dateFormat.format(time);
		System.out.println("活动发布时间和结束时间："+startTime+"--"+endTime);
		survey suObj=new survey();
		suObj.setWID(WID);
		suObj.setACTIVITY(Activity);
		suObj.setSTARTTIME(startTime);
		suObj.setENDTIME(endTime);
		suObj.setMYGROUP(group);
		suObj.setTEAID(teaID);
		surveyFunction.insertRecord(suObj);
		out.println("<script>alert('活动发布成功');location.href='../Login/welcome1.jsp';</script>");
		return;
//		surveyFunction.insertRecord(sql);
		
		
	}

}
