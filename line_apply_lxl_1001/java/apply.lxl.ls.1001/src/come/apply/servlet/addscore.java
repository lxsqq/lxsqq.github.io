package come.apply.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.apply.dao.Dao;

/**
 * Servlet implementation class addscore
 */
@WebServlet("/addscore")
public class addscore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addscore() {
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
		
		String score=request.getParameter("score");
		 String id=request.getParameter("id");
		 
		 System.out.println(score);
		 int status=0;
		 Dao d=new Dao();
		 String re="";
		 String i=d.testoverst(id);
         boolean bb=d.ishad(id);
		 
         System.out.println(bb);
		 if (bb) {	
			 System.out.println(i);
			if(!i.equals("")){
				re="考过啦你都"+i;
				status=1;
			}else{
				status=0;
				d.updatesc(id, score);
				re="考试完毕";
				status=0;
			}
		 }else{
			re="检查证件号";
			status=2;
			
		}
			
		
		 
		 Map<String, Object> mp=new HashMap<>();
		 mp.put("msg", re);
		 mp.put("status", status);
		 
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
