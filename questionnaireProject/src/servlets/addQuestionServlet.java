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
import po.*;
import service.logFunction;
import service.optionFunction;
import service.questionFunction;

/**
 * Servlet implementation class addAQuestionServlet
 */
@WebServlet("/addAQuestionServlet")
public class addQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addQuestionServlet() {
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
	
		HttpSession session=request.getSession();
	
		//动作
		String addQuestion=request.getParameter("addQuestion");
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
		logObj.setOperation(addQuestion);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String stem=new String(request.getParameter("stem").getBytes("ISO-8859-1"),"UTF-8");
		String type=request.getParameter("type");
		String optionNum=request.getParameter("optionNum");
		String TEAID=session.getAttribute("用户名").toString();
		session.setAttribute("题干", stem);
		session.setAttribute("类型", type);
		session.setAttribute("选项个数", optionNum);
//		System.out.println("问卷号："+session.getAttribute("问卷号"));
		
		if(type.equals("jianda"))
		{
			String sql="INSERT INTO QUESTION(STEM,OPTIONNUM,TYPE,TEAID)VALUES('";
			sql+=stem+"','1','"+type+"','"+TEAID+"')";
			System.out.println("插入题目表sql语句："+sql);
			questionnaireInterface qObj=new questionFunction();
			//插入简答题目信息
			qObj.insertRecord(sql);
			
			String getTID="SELECT * FROM QUESTION WHERE STEM='"+stem+"' AND TEAID='"+TEAID+"'";
			String TID=((question)qObj.selectRecord(getTID).get(0)).getTID();
			session.setAttribute("题号", TID);
			
			String osql="INSERT INTO MYOPTION(TID,optionID,answerID)VALUES('";
			osql+=TID+"','"+0+"','"+0+"')";
			questionnaireInterface opObj=new optionFunction();
			opObj.insertRecord(osql);
			
			session.setAttribute("选项个数", 1);
			out.println("<script>alert('简答题目信息添加成功');location.href='chooseQuestion.jsp';</script>");
			return;
			
			
		}else
		{
			String sql="INSERT INTO QUESTION(STEM,OPTIONNUM,TYPE,TEAID)VALUES('";
			sql+=stem+"','"+optionNum+"','"+type+"','"+TEAID+"')";
			System.out.println("插入题目表sql语句："+sql);
			questionnaireInterface qObj=new questionFunction();
			qObj.insertRecord(sql);
			
			String getTID="SELECT * FROM QUESTION WHERE STEM='"+stem+"' AND TEAID='"+TEAID+"'";
			String TID=((question)qObj.selectRecord(getTID).get(0)).getTID();
			session.setAttribute("题号", TID);
			System.out.println("题号："+session.getAttribute("题号"));
			
			
			out.println("<script>alert('题干信息添加成功,请添加选项信息！');location.href='addOption.jsp';</script>");
			return;
		}
		
	}

}
