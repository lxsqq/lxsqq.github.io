package demo_students.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo_students.code.code;
import demo_students.code.sentCode;

/**
 * Servlet implementation class Pcode
 */
@WebServlet("/Pcode")
public class Pcode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pcode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String phonenum=  request.getParameter("phonenum");
	     code c=new code();
	       String s= c.content();
	       
	       sentCode sc=new sentCode();
	       String xs=sc.sendCode(phonenum, s);
	       response.setContentType("text/html;charset=utf-8");
		    response.getWriter().println("{\"status\":³É¹¦\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
