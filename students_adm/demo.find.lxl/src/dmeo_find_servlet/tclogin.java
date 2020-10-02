package dmeo_find_servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.find.code.code;

import demo.find.lxl.dao.dao;
import demo.find.lxl.pojo.pojo;

/**
 * Servlet implementation class tclogin
 */
@WebServlet("/tclogin")
public class tclogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tclogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String username=  request.getParameter("username");
		String password=  request.getParameter("password");
		String logcode=request.getParameter("logcode");
		String logcode1=request.getParameter("logcode1");
		System.out.println(logcode);
		System.out.println(logcode1);
		System.out.println(password);
		
		String res="";
		String re="";
		dao d=new dao();
		pojo pj=new pojo();
		int status=0;
		if (logcode.equals(logcode1)){
			boolean db=d.ishad(username);
			if (db) {
				 pj=d.login(username);
				 System.out.println(pj.getPassword());
				if (password.equals(pj.getPassword())) {
					res=username+"登陆成功!";
					//res = "success";
					status=0;
				}else{
					res=username+"密码输入错误";
					//res = "password error";
					status=1;
				}
			}else{
				res="用户名不存在";
				//res = "fail";
				status=2;
			}
		}else{
			re="验证码错误";
		}
		Map<String, Object> mp=new HashMap<>();
		mp.put("codemsg", re);
		mp.put("msg", res);
		mp.put("status", status);
		mp.put("result", pj);
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
