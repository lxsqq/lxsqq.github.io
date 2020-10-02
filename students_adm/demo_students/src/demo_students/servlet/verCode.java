package demo_students.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import demo_students.dao.dao;
import demo_students.pojo.pojo;

/**
 * Servlet implementation class verCode
 */
@WebServlet("/verCode")
public class verCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String phonenum=	request.getParameter("phonenum");
	  String scode=request.getParameter("scode");
	  dao d=new dao();
	  pojo pj=d.select(phonenum);
	  Map<String, Object> mp= new HashMap<>();
	  if (scode.equals(pj.getPhonenum())) {
		mp.put("stutus", 0);
	}
	  response.setContentType("text/html;charset=utf-8");
	    response.getWriter().println(JSON.toJSON(mp));
      	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
