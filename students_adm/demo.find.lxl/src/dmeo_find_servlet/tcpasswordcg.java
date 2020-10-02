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

import demo.find.lxl.dao.dao;
import demo.find.lxl.pojo.pojo;

/**
 * Servlet implementation class tcpasswordcg
 */
@WebServlet("/tcpasswordcg")
public class tcpasswordcg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tcpasswordcg() {
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
		String username =request.getParameter("username");
		String newpassword=request.getParameter("newpassword");
		String oldpassword=request.getParameter("oldpassword");
		
		String res="";
		dao d=new dao();
		int status=0;
		boolean bb=d.ishad(username);
		if (bb) {
			pojo pj=d.login(username);
		    if (oldpassword.equals(pj.getPassword())) {
		    	
				d.update(username,newpassword);
				res="修改成功，密码为："+newpassword;
				status=0;
			}else {
				res="密码输入错误";
				status=1;
				System.out.println(pj.getPassword());
				System.out.println(oldpassword);
			}
		}else{
			res="用户名不存在";
			status=2;
		
		}
		
		Map<String, Object> mp=new HashMap<>();
		mp.put("msg", res);
		mp.put("stutus", status);
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
