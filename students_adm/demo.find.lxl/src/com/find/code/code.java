package com.find.code;

import java.util.Random;

public class code {
   public String createCode() {
	   String num="1234567890qwertyuiopasdfghjklzxcvbnm";
	     int len= num.length();
	     Random o=new Random();
	     String re="";
	     for(int i=0;i<6;i++){
	    	 int l=o.nextInt(len);
	    	 char p= num.charAt(l);
	    	 re=re+p;
	     }
	     return re;
}
     
}
