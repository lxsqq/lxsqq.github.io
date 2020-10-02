package com.find.code;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SentCode {
public String Scd(String phonenum,String cd) {
	 DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FzDYbeTbmxsSLwxhhP8", "josdFVZWvVlzFcCmOc9Y6JqmQPW4t9");
     IAcsClient client = new DefaultAcsClient(profile);

     CommonRequest request = new CommonRequest();
     request.setMethod(MethodType.POST);
     request.setDomain("dysmsapi.aliyuncs.com");
     request.setVersion("2017-05-25");
     request.setAction("SendSms");
     request.putQueryParameter("RegionId", "cn-hangzhou");
     request.putQueryParameter("PhoneNumbers", phonenum);
     request.putQueryParameter("SignName", "Æó¶ì»Ê");
     request.putQueryParameter("TemplateCode", "SMS_203676505");
     request.putQueryParameter("TemplateParam", "{\"code\":\""+cd+"\"}");
     try {
         CommonResponse response = client.getCommonResponse(request);
         System.out.println(response.getData());
         return response.getData();
     } catch (ServerException e) {
         e.printStackTrace();
         
     } catch (ClientException e) {
         e.printStackTrace();
     }
	return null;
}
}
