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
import com.apply.dao.Cdao;
import com.apply.pojo.Codepojo;

/**
 * Servlet implementation class ver
 */
@WebServlet("/ver")
public class ver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ver() {
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
		  String code=request.getParameter("code");
		  
		  String res="";
		  Cdao d=new Cdao();
		  
		  int status=0;
		  Codepojo cp=d.select(phonenum);
		  Map<String, Object> mp=new HashMap<>();
		 
		  if (code.equals(cp.getCode())) {
			res="验证码正确";
			status=0;
		}else{
			res="验证码输入有误";
			status=2;
		}
		  mp.put("msg", res);
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
