package com.apply.code;

import java.util.Random;

public class rdcode {
    public String Dcode(){
		String num="1234567890";
		int len=num.length();
		Random r=new Random();
		String re="";
		for(int i=0;i<4;i++){
			int o=r.nextInt(len);
			char p=num.charAt(o);
			re=re+p;
		
		}
		return re;
	}
}
