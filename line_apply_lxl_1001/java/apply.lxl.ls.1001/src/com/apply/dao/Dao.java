package com.apply.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.apply.pojo.Pojo;
import com.apply.pojo.TcPojo;
import com.apply.pojo.TestPojo;

public class Dao {
      public Connection content() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/line","root","123456");
		    return c;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
      //网上注册
      public int updata(String username,String password,String id,String name,String phonenum) {
		String sql="insert into line.stds (username,password,id,name,phonenum) values('"+username+"','"+password+"','"+id+"','"+name+"','"+phonenum+"');";
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
      //查验id
      public boolean ishad(String id) {
		String sql="select*from line.stds where id='"+id+"';";
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
      //学生登录id+密码
      public Pojo selectStd(String id) {
		String sql="select*from line.stds where id='"+id+"';";
		try {
			PreparedStatement pre=content().prepareStatement(sql);
			ResultSet re=pre.executeQuery();
			Pojo pj=new Pojo();
			while(re.next()){
				pj.setId(id);
				pj.setPassword(re.getString("password"));
				return pj;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
      
      //手机号验证码登录
      public boolean codeLog(String phonenum) {
		String sql="select*from line.stds where phonenum='"+phonenum+"'";
		try {
			PreparedStatement pre= content().prepareStatement(sql);
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
      
      //修改密码
      public int updata(String id,String newpassword ) {
		String sql="update line.stds set password='"+newpassword+"' where id='"+id+"';";
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
      
      //教师登录
      public Pojo TcLog(String username) {
		String sql="select*from line.tec where username='"+username+"';";
		try {
			PreparedStatement pre =content().prepareStatement(sql);
			ResultSet re=pre.executeQuery();
			Pojo pj=new Pojo();
			while(re.next()){
				pj.setUsername(username);
				pj.setPassword(re.getString("password"));
			return pj;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
      //教师修改密码啊
      public int tcccpw(String username,String newpassword) {
		String sql="update line.tec set password='"+newpassword+"' where username='"+username+"';";
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
      //教师查验
      public boolean ishadtc(String username) {
  		String sql="select*from line.tec where username='"+username+"';";
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
      //考试成绩
      public int updatesc(String id,String score) {
		String sql="update line.stds set score='"+score+"' where id='"+id+"'; ";
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
      
      //教师全查询
      public List<Pojo> selecall() {
		String sql="select*from line.stds";
		try {
			 PreparedStatement pre=content().prepareStatement(sql);
			 ResultSet re=pre.executeQuery();
			List<Pojo> ls=new ArrayList<>();
			while(re.next()){
				Pojo pj=new Pojo();
				pj.setId(re.getString("id"));
				pj.setName(re.getString("name"));
				pj.setPassword(re.getString("password"));
				pj.setIdstds(re.getString("idstds"));
				pj.setPhonenum(re.getString("phonenum"));
				pj.setScore(re.getString("score"));
				pj.setUsername(re.getString("username"));
			    ls.add(pj);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
      //出题
      public int addqt(String question,String a,String b,String c,String d,String answ) {
		String sql="insert into line.test (question,a,b,c,d,answ)values('"+question+"','"+a+"','"+b+"','"+c+"','"+d+"','"+answ+"')";
		try {
			 PreparedStatement pre=content().prepareStatement(sql);
			 int i=pre.executeUpdate();
			 content().close();
			 return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
      
      //随机出题
      public List<TestPojo> rdquestion() {
		String sql="select*from line.test order by rand() limit 10";
		try {
			PreparedStatement pre=content().prepareStatement(sql);
			ResultSet re=pre.executeQuery();
			List<TestPojo> ls=new ArrayList<>();
			while(re.next()){
				TestPojo tp=new TestPojo();
				tp.setIdx(re.getInt("idx"));
				tp.setQuestion(re.getString("question"));
				tp.setA(re.getString("a"));
				tp.setB(re.getString("b"));
				tp.setC(re.getString("c"));
				tp.setD(re.getString("d"));
				tp.setAnsw(re.getString("answ"));
				ls.add(tp);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
      
      
      //携带id去全查询
    /*  public void color(String id) {
		String sql="select stds from line.stds where id='"+id+"'";
		try {
			 PreparedStatement pre= content().prepareStatement(sql);
			ResultSet re= pre.executeQuery();
			int i=0;
			while(re.next()){
				i=i+re.getin
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
      
      //不能重新考试
      public String testoverst(String id) {
		String sql="select score from line.stds where id='"+id+"' ";
		try {
			PreparedStatement pre=content().prepareStatement(sql);
			ResultSet re=pre.executeQuery();
			String i="";
			while(re.next()){
			i=re.getString("score");
			}
			if (i == null) {
				i = "";
			}
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
      
      //对答案
      public String findan(int idx) {
		String sql="select answ from line.test where idx='"+idx+"'";
		try {
			 PreparedStatement pre=content().prepareStatement(sql);
			 ResultSet re= pre.executeQuery();
			 String answer="";
			 while(re.next()){
				 answer=re.getString("answ");
				 
			 }
			 return answer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
      
      //学生群查询
      public List<Pojo> stdselecall() {
  		String sql="select*from line.stds";
  		try {
  			 PreparedStatement pre=content().prepareStatement(sql);
  			 ResultSet re=pre.executeQuery();
  			List<Pojo> ls=new ArrayList<>();
  			while(re.next()){
  				Pojo pj=new Pojo();
  				pj.setId(re.getString("id"));
  				pj.setName(re.getString("name"));
  				//pj.setPassword(re.getString("password"));
  				pj.setIdstds(re.getString("idstds"));
  				//pj.setPhonenum(re.getString("phonenum"));
  				pj.setScore(re.getString("score"));
  				pj.setUsername(re.getString("username"));
  			    ls.add(pj);
  			}
  			return ls;
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}
      
      //老师端获取旧密码
      public TcPojo selecttcpw(String username) {
		String sql="select *from line.tec where username='"+username+"'";
		try {
			PreparedStatement pre = content().prepareStatement(sql);
			ResultSet re=pre.executeQuery();
			TcPojo tp=new TcPojo();
			while(re.next()){
				tp.setUsername(username);
				tp.setPassword(re.getString("password"));
				return tp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
      
      //老师改学生密码系统
      public int tecchangestpw(String id ,String password) {
		String sql="update line.stds set password='"+password+"' where id='"+id+"'";
		try {
			 PreparedStatement pre= content().prepareStatement(sql);
			int i= pre.executeUpdate();
			 return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
      public static void main(String[] args) {
		Dao d=new Dao();
		//System.out.println(d.testoverst("111111111111111111"));
		//System.out.println(d.content());
		//System.out.println(d.selecttcpw("鲁迅"));
		System.out.println(d.tcccpw("鲁迅", "000000"));
	}
}
