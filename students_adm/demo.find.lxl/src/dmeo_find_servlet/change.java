package dmeo_find_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.find.lxl.dao.dao;
import demo.find.lxl.pojo.pojo;

/**
 * Servlet implementation class change
 */
@WebServlet("/change")
public class change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","*");
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","*");
		response.setHeader("Access-Control-Allow-Credentials","true");
		
		String username=  request.getParameter("username");
		String password=  request.getParameter("password");
		String idex=  request.getParameter("idex");
		String china=  request.getParameter("china");
		String math=  request.getParameter("math");
		String engl=  request.getParameter("engl");
		String and=  request.getParameter("and");
		String phonenum=request.getParameter("phonenum");
		System.out.println(and);
		String res="";
		dao d=new dao();
		int i = d.update(username, password, china, math, engl, and,phonenum);
		res=username+"ÐÞ¸Ä³É¹¦";
		System.out.println(i);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
