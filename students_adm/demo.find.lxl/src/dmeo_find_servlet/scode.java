package dmeo_find_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.find.code.SentCode;
import com.find.code.code;

import demo.find.lxl.dao.dao;

/**
 * Servlet implementation class scode
 */
@WebServlet("/scode")
public class scode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phonenum=request.getParameter("phonenum");
		code c=new code();
		String cc=   c.createCode();
		
		SentCode sc=new SentCode();
		String s=sc.Scd(phonenum, cc);
		
		dao d=new dao();
		d.addcode(phonenum, cc);
		  response.setContentType("text/html;charset=utf-8");
		  response.getWriter().println("{\"status\":\"0\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
