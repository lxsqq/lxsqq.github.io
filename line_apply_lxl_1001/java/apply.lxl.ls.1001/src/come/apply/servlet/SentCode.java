package come.apply.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apply.code.Sdcode;
import com.apply.code.rdcode;
import com.apply.dao.Cdao;
import com.apply.dao.Dao;

/**
 * Servlet implementation class SentCode
 */
@WebServlet("/SentCode")
public class SentCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentCode() {
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
		
		      String phonenum= request.getParameter("phonenum");
		      
		      rdcode rd=new rdcode();
		      String r=rd.Dcode();
		      
		      Sdcode ss= new Sdcode();
	          String sc=ss.sendCode(phonenum,r);
	          
		      Cdao d=new Cdao();
		      boolean bb=d.ishad(phonenum);
		      if (bb) {
				d.updata(phonenum, r);
			}else {
				 d.addcode(phonenum,r);
			}
	      
	          
	          response.setContentType("text/html;charset=utf-8");
	          response.getWriter().println("{\"msg\":\"ok\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
