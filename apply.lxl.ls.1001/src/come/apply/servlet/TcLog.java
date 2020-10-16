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
import com.apply.pojo.Pojo;

/**
 * Servlet implementation class TcLog
 */
@WebServlet("/TcLog")
public class TcLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TcLog() {
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
		
		String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   
	   String re="";
	   int status=0;
	   Dao d=new Dao();
	   boolean bb=d.ishadtc(username);
	   if (bb) {
		Pojo pj=d.TcLog(username);
		if (password.equals(pj.getPassword())) {
			re=username+"老师登录成功";
			status=0;
		}else {
			re="密码错误";
			status=1;
		}
	}else{
		re="用户名不存在";
		status=2;
	}
	   
	   Map<String, Object> mp= new HashMap<>();
	   mp.put("msg", re);
	   mp.put("status",status);
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
