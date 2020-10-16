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
 * Servlet implementation class answercc
 */
@WebServlet("/answercc")
public class answercc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public answercc() {
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
		
		String answer=request.getParameter("answer");
		
		int score=0;
		Dao d=new Dao();
		Map<String, Object> mp=new HashMap<>();
		
	   mp=JSON.parseObject(answer);
	   for(String key:mp.keySet()){
		   String s=d.findan(Integer.parseInt(key));
		   if (s.equals(mp.get(key))) {
			score=score+10;
		}
	   }
	   System.out.println(mp);
	   Map<String, Object> 	res=new HashMap<>();
	   res.put("score", score);
	   res.put("msg", "ok");
	   response.setContentType("text/html;charset=utf-8");
	   response.getWriter().println(JSON.toJSON(res));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
