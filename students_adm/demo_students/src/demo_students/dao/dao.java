package demo_students.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo_students.pojo.pojo;

public class dao {
    public Connection content() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=	DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/menu","root","123456");
		    return c;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
    //Ìí¼ÓÑéÖ¤Âë
    public int addCode(String phonenum,String code) {
		String sql="insert into menu.syscode (phonenum,code) values('"+phonenum+"','"+code+"'); ";
		try {
			PreparedStatement pre= content().prepareStatement(sql);
			int i=pre.executeUpdate();
			content().close();
			return i;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
    public pojo select(String phonenum ) {
		String sql="select*from munu.syscode where phonenum='"+phonenum+"' ;";
		try {
			PreparedStatement pre=content().prepareStatement(sql);
			ResultSet re= pre.executeQuery();
			pojo pj=new pojo();
			while(phonenum.equals(pj.getPhonenum())){
				pj.setCode(re.getString("code"));
				pj.setPhonenum(phonenum);
				
			}
			return pj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    public static void main(String[] args) {
		dao d=new dao();
		System.out.println(d.content());
	}
}
