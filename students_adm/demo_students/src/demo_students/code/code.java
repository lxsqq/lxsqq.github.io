package demo_students.code;

import java.util.Random;

public class code {
     public String content() {
    	 String num="0123456789";
         int len =num.length();
         Random r=new Random();
         String re="";
         for(int i=0;i<6;i++){
       	  int o=r.nextInt(len);
       	  char p=num.charAt(o);
       	  re=re+p;
         }
         return re;
	}
}
