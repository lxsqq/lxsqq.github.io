package com.apply.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apply.pojo.Codepojo;

public class Cdao {
     public Connection content() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/line","root","123456");
		     return c;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
     //数据库添加号码储存
     public int addcode(String phonenum,String code ) {
		String sql="insert into line.pcode (phonenum,code) values ('"+phonenum+"','"+code+"')";
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
    //数据库取值对比 
     public Codepojo select(String phonenum) {
    	 String sql="select*from line.pcode where phonenum='"+phonenum+"';";
    	 try {
			PreparedStatement pre=content().prepareStatement(sql);
			ResultSet re=pre.executeQuery();
			Codepojo cp=new Codepojo();
			while(re.next()){
				cp.setPhonenum(phonenum);
				cp.setCode(re.getString("code"));
				return cp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
     
     //s
     public boolean ishad(String phonenum) {
		String sql="select*from line.pcode where phonenum='"+phonenum+"';";
		try {
			PreparedStatement pre=content().prepareStatement(sql);
			ResultSet re=  pre.executeQuery();
			while(re.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
     
     //换验证码
     public int updata(String phonenum,String code) {
		String sql="UPDATE line.pcode SET code='"+code+"' WHERE phonenum='"+phonenum+"';";
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
     public static void main(String[] args) {
		Cdao d=new Cdao();
		Codepojo cp=new Codepojo();
		cp = d.select("17733569416");
		System.out.println(cp.getCode());
	}
}
