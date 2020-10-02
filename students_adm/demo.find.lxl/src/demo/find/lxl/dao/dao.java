package demo.find.lxl.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.find.lxl.pojo.MsgPojo;
import demo.find.lxl.pojo.pojo;

public class dao {
   public Connection content() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/menu","root","123456");
	    return c;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
} 
   //老师添加学生
   public void add(String username,String password,String china,String math,String engl,String and,String phonenum) {
	  String sql=" INSERT INTO menu.info (username, password, china, math, engl,xand,phonenum) VALUES ('"+username+"', '"+password+"', '"+china+"', '"+math+"', '"+engl+"','"+and+"','"+phonenum+"');";
      try {
    	  PreparedStatement pre= content().prepareStatement(sql);
    	  pre.executeUpdate();
    	  content().close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   //学生登录
   public pojo login(String username) {
	String sql="select*from menu.info where username='"+username+"';";
	try {
		PreparedStatement pre=content().prepareStatement(sql);
		ResultSet re=pre.executeQuery();
		pojo pj=new pojo();
		while(re.next()){
			pj.setUsername(username);
			pj.setPassword(re.getString("password"));
			pj.setChina(re.getString("china"));
			pj.setMath(re.getString("math"));
			pj.setEngl(re.getString("engl"));
			pj.setAnd(re.getString("xand"));
		}
		return pj;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
} 
   //学生查询                   不能实现
   public pojo select(String username,String password,String china,String math,String engl,String and) {
	String sql="select*from menu.info(username,password,china,math,engl,xand) where ('"+username+"', '"+password+"' );";
     try {
    	 PreparedStatement pre=  content().prepareStatement(sql);
    	 ResultSet re= pre.executeQuery();
    	 content().close();
    	 pojo pj=new pojo();
    	 while(re.next()){
    	
    		 pj.setUsername(re.getNString(username));
    		 pj.setPassword(re.getString(password));
    		 pj.setChina(re.getString(china));
    		 pj.setMath(re.getString(math));
    		 pj.setAnd(re.getString(and));
    		
    		 
    	 }
    	 return pj;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

   }
   //验证
   public boolean ishad(String username) {
	String sql="select*from menu.info where username='"+username+"';";
	try {
		PreparedStatement pre=content().prepareStatement(sql);
		ResultSet re=pre.executeQuery();
		while(re.next()){
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
   //查询全部学生
   public List<pojo> selectall() {
	 String sql="select*from menu.info;";
	 try {
		 PreparedStatement pre=content().prepareStatement(sql);
		 ResultSet re= pre.executeQuery();
		 content().close();
	      List<pojo> ls=new ArrayList<>();
	      while(re.next()){
	    	  pojo pj=new pojo();
	    	  pj.setPassword(re.getString("password"));
	    	  pj.setUsername(re.getString("username"));
	    	  pj.setIdex(re.getInt("idex"));
	    	  pj.setMath(re.getString("math"));
	    	  pj.setChina(re.getString("china"));
	    	  pj.setEngl(re.getString("engl"));
	    	  pj.setAnd(re.getString("xand"));
	    	  pj.setPhonenum(re.getString("phonenum"));
	    	  ls.add(pj);
	      }
	      return ls;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	 
} 
   //删除学生
    public int del(String username) {
		String sql="delete from menu.info where username='"+username+"';";
		try {
			PreparedStatement pre= content().prepareStatement(sql);
			int i=pre.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
    //新增学生
    public int  update(String username ,String password,String china,String math,String engl,String and,String phonenum) {
		String sql="UPDATE menu.info SET username='"+username+"', password='"+password+"', china='"+china+"', math='"+math+"', engl='"+engl+"', xand='"+and+"',phonenum='"+phonenum+"' WHERE username='"+username+"';";
	    try {
	    	PreparedStatement pre=content().prepareStatement(sql);
	    	int i=pre.executeUpdate();
	    	return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    } 
  //添加手机验证码  
    public int addcode(String phonenum,String code) {
		String sql="insert into menu.syscode(phonenum,code) value('"+phonenum+"','"+code+"');";
		try {
			PreparedStatement pre=content().prepareStatement(sql);
			int i=pre.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
    
  //查询验证码  
    public MsgPojo selectCd(String phonenum) {
		String sql=" select*from menu.syscode where phonenum='"+phonenum+"';";
		try {
			PreparedStatement pre=content().prepareStatement(sql);
			ResultSet re=pre.executeQuery();
			MsgPojo mj=new MsgPojo();
		     while(re.next()){
		    	 mj.setPhonenum(phonenum);
		    	 mj.setCode(re.getString("code"));
		    	 
		     }
		     content().close();
		     return mj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    
   public static void main(String[] args) {
	dao d=new dao();
	//System.out.println(d.selectall());
	d.update("ww", "1", "1", "1", "1", "1","1");
}
}
