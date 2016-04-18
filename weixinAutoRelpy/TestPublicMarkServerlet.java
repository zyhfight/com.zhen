package com.zhen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhen.service.AutoReply;
import com.zhen.service.ServletPostReader;

/**
 * Servlet implementation class TestPublicMarkServerlet
 */
@WebServlet("/TestPublicMarkServerlet")
public class TestPublicMarkServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPublicMarkServerlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out=response.getWriter();
		response.setStatus(200);
		//获取微信关注用户发送的xml字符串
		//servletPostReader类的getContent方法可防止提交的数据被截断
		String data=ServletPostReader.getContent(request, response);
		//自动回复消息
		AutoReply.autoReply(data, out);
	}

}
