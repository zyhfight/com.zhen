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

import ServiceInterface.questionnaireInterface;
import po.log;
import service.answerFunction;
import service.logFunction;

/**
 * Servlet implementation class enterAnswerServlet
 */
@WebServlet("/enterAnswerServlet")
public class enterAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enterAnswerServlet() {
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
		String enterAnswer=request.getParameter("enterAnswer");
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
		logObj.setOperation(enterAnswer);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String answerContent=new String(request.getParameter("answerContent").getBytes("ISO-8859-1"),"UTF-8");
		String teaID=(String)session.getAttribute("用户名");
		questionnaireInterface aObj=new answerFunction();
		String sql="INSERT INTO ANSWER(CONTENT,TEAID)VALUES('"+answerContent+"','";
		sql+=teaID+"')";
		System.out.println("插入答案表sql语句："+sql);
		aObj.insertRecord(sql);
		out.println("<script>alert('答案录入成功!');location.href='addOption.jsp';</script>");
		return;
	}

}
