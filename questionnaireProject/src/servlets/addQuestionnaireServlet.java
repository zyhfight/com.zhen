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

import ServiceInterface.questionnaireInterface;
import po.log;
import po.questionnaire;
import service.logFunction;
import service.questionnaireFunction;

/**
 * Servlet implementation class addAQuestionnaireServlet
 */
@WebServlet("/addAQuestionnaireServlet")
public class addQuestionnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addQuestionnaireServlet() {
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
		String addQuestionnaire=request.getParameter("addQuestionnaire");
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
		logObj.setOperation(addQuestionnaire);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String subject=new String(request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");
		String stemNum=new String(request.getParameter("stemNum").getBytes("ISO-8859-1"),"UTF-8");
		String TEAID=(String) session.getAttribute("用户名");
		session.setAttribute("主题", subject);
		session.setAttribute("题目数", stemNum);
		
		String sql="SELECT * FROM QUESTIONNAIRE WHERE TEAID='"+TEAID+"' AND subject='"+subject+"'";
		questionnaireInterface quesObj=new questionnaireFunction();
//		System.out.println("查询问卷表sql语句"+sql);
		List<Object> list=quesObj.selectRecord(sql);
		if(list!=null)
		{
			out.println("<script>alert('此问卷名已被使用！');location.href='addQuestionnaire.jsp';</script>");
			return;
		}
	
		sql="INSERT INTO QUESTIONNAIRE(SUBJECT,STEMNUM,TEAID,CREATETIME)VALUES('";
		sql+=subject+"','"+stemNum+"','"+TEAID+"',NOW());";
//		System.out.println("插入问卷表sql语句"+sql);
		
		quesObj.insertRecord(sql);
		sql="SELECT * FROM QUESTIONNAIRE WHERE TEAID='"+TEAID+"' AND subject='"+subject+"'";
		sql+=" AND stemNum='"+stemNum+"'";
//		System.out.println("查询问卷表sql语句"+sql);
		String WID=((questionnaire)quesObj.selectRecord(sql).get(0)).getWID(); 
		System.out.println("问卷号："+WID);
		session.setAttribute("问卷号", WID);
		out.println("<script>alert('问卷信息添加成功');location.href='chooseQuestion.jsp';</script>");
		return;
		
	}

}
