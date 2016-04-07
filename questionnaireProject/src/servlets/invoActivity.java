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
import po.*;
import po.questionnaire;
import service.collectAnswerFunction;
import service.logFunction;
import service.questionnaireFunction;
import service.restrictFunction;

/**
 * Servlet implementation class invoActivity
 */
@WebServlet("/invoActivity")
public class invoActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public invoActivity() {
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		//动作
		String invoActivity=request.getParameter("invoActivity");
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
		logObj.setOperation(invoActivity);
		//添加日志信息
		logFunction.insertLog(logObj);
		
		
		
		String WA=new String(request.getParameter("WID-Activity").getBytes("ISO-8859-1"),"UTF-8");
		String WID=WA.substring(0,WA.indexOf("#"));
		String ACTIVITY=WA.substring(WA.indexOf("#")+1,WA.indexOf("$"));
//		System.out.println("选择的问卷号"+WID);
//		System.out.println("选择的活动名称:"+ACTIVITY);
		int myFlag=0;
		String falg="SELECT * FROM collectAnswer WHERE WID='"+WID+"' AND STUID='"+usrName+"' AND ACTIVITY='"+ACTIVITY+"'";
		List<Object>clist=collectAnswerFunction.selectRecord(falg);
		String sql00="SELECT * FROM QUESTIONNAIRE WHERE WID='"+WID+"'";
		questionnaireInterface quenn=new questionnaireFunction();
		List<Object>list00=quenn.selectRecord(sql00);
		int stemNum=Integer.parseInt(((questionnaire)list00.get(0)).getStemNum());
		
		String tsql="SELECT * FROM MYRESTRICT WHERE WID='"+WID+"'";
		List<Object>tlist=restrictFunction.selectRecord(tsql);
		if(tlist!=null&&clist!=null)
		{
			
			for(int n=0;n<tlist.size();n++)
			{
	//			int cri=Integer.parseInt(((myRestrict)tlist.get(n)).getCrisisTID());
				int endno=Integer.parseInt(((myRestrict)tlist.get(n)).getEndTID());
	//			int start=Integer.parseInt(((myRestrict)tlist.get(n)).getStartTID());
	//			int num=cri+endno-start+1;
				int ensnum=Integer.parseInt(((collectAnswer)clist.get(clist.size()-1)).getTIDNO());
				if(ensnum==endno)
				{
					myFlag=1;
				}
				
			}
			
		}
		
		
		if(clist!=null&&clist.size()!=stemNum&&myFlag==0)
		{
			String del="DELETE FROM collectAnswer WHERE WID='"+WID+"' AND STUID='"+usrName+"' AND ACTIVITY='"+ACTIVITY+"'";
			System.out.println("删除未答完问卷sql语句"+del);
			collectAnswerFunction.insertRecord(del);
		}
		clist=collectAnswerFunction.selectRecord(falg);
		if(clist!=null)
		{
			out.println("<script>alert('您已参加过此活动');location.href='invoActivity.jsp';</script>");
			return;
		}
		
		
		
		session.setAttribute("问卷号", WID);
		session.setAttribute("活动名称", ACTIVITY);
		//判断有无约束条件
		String sql="SELECT * FROM MYRESTRICT WHERE WID='"+WID+"'";
		List<Object>list=restrictFunction.selectRecord(sql);
		if(list==null)
		{
			out.println("<script>alert('问卷选择成功，开始答卷');location.href='answerActivity.jsp';</script>");
			return;
		}else
		{
			session.setAttribute("题目编号-1",0);
			session.setAttribute("题目编号",1);
			
			String sql0="SELECT * FROM QUESTIONNAIRE WHERE WID='"+session.getAttribute("问卷号")+"'";
			questionnaireInterface quennier=new questionnaireFunction();
			List<Object>list0=quennier.selectRecord(sql0);
			session.setAttribute("问卷题目数", ((questionnaire)list0.get(0)).getStemNum());
			
			
			out.println("<script>alert('问卷选择成功，开始答卷');location.href='answerRestrictActivity.jsp';</script>");
			return;
		}
		
	}

}
