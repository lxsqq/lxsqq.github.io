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
import com.apply.code.rdcode;
import com.apply.dao.Cdao;
import com.apply.dao.Dao;
import com.apply.pojo.Codepojo;

/**
 * Servlet implementation class enroll
 */
@WebServlet("/enroll")
public class enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enroll() {
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
		
		
		  String username= request.getParameter("username");
 	      String password=request.getParameter("password");
 	      String id=request.getParameter("id");
 	      String phonenum=request.getParameter("phonenum");
 	      String name=request.getParameter("name");
 	     // String code=request.getParameter("code");
 	      //System.out.println("code:"+code);
 	      
 	      String res="";
 	      rdcode rr=new rdcode();
 	      
 	      Dao d=new Dao();
 	      int status=0;
 	      boolean bb=d.ishad(id);
 	      int i = 0;
 	      System.out.println(bb);
 	      if(bb) {
 	    		
			    res="你已注册过该网站";
				status=1;
				return;
		}else{
			
				i = d.updata(username, password, id, name, phonenum);
					res=name+"注册成功";
			        status=0;
			
			   
	}
 	      
 	  System.out.println(i);
 	  Map<String, Object> mp =new HashMap<>();
 	  mp.put("status", status);
 	  mp.put("msg", res);
 	  
 	  System.out.println(1);
 	  System.out.println(JSON.toJSON(mp));
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
