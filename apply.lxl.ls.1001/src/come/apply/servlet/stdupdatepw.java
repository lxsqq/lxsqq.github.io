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
import com.apply.pojo.TcPojo;

/**
 * Servlet implementation class stdupdatepw
 */
@WebServlet("/stdupdatepw")
public class stdupdatepw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stdupdatepw() {
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
		
		String id=request.getParameter("id");
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		System.out.println(id);
		System.out.println(oldpassword);
		
		String res="";
		
		Dao d=new Dao();
        int status=0;
	 boolean bb=d.ishad(id);
		if (bb) {
			Pojo pj=d.stdpassword(id);
			System.out.println(d.stdpassword(id));
			if(oldpassword.equals(pj.getPassword())){
			   d.stdupdate(id, newpassword);
				System.out.println(pj.getPassword());
				res="密码修改成功"+newpassword;
				status=0;
			}else{
				status=2;
				res="检查之前密码是否正确";
			}
		}else{
			status=3;
			res="再次身份证号";
		}
		Map<String , Object> mp=new HashMap<>();
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
