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
import com.apply.dao.Dao;
import com.apply.pojo.Codepojo;

/**
 * Servlet implementation class codeLog
 */
@WebServlet("/codeLog")
public class codeLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public codeLog() {
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
		
		String phonenum=request.getParameter("phonenum");
		String code=request.getParameter("code");
		int status=0; 
		String re="";
		Cdao c=new Cdao();
		Codepojo cp=c.select(phonenum);
		if (code.equals(cp.getCode())) {
			Dao d=new Dao();
			boolean bb=d.codeLog(phonenum);
			if (bb) {
				re="登录成功";
				status=0;
			}else{
				re="手机号不存在";
				status=1;
			}
		}else{
			re="验证码错误";
			status=3;
		}
		
		Map<String, Object> mp= new HashMap<>();
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
