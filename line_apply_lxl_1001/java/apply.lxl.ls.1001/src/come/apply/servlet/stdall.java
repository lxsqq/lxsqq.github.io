package come.apply.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.apply.dao.Dao;
import com.apply.pojo.Pojo;

/**
 * Servlet implementation class stdall
 */
@WebServlet("/stdall")
public class stdall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stdall() {
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
		
		Dao d=new Dao();
		List<Pojo> ls=d.stdselecall();
		
		Map<String, Object> mp=new HashMap<>();
		mp.put("msg", "ok");
		mp.put("result", ls);
		
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
