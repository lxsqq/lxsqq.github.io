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
import demo.find.lxl.pojo.MsgPojo;

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
		
		//—È÷§
		String phonenum=request.getParameter("phonenum");
		String code=request.getParameter("code");
		
		dao d=new dao();
		MsgPojo mj=d.selectCd(phonenum);
		
		Map<String, Object> mp = new HashMap<>();
		if (code.equals(mj.getCode())) {
			mp.put("status", "ok");
		}
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
