package demo_students.code;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;


public class sentCode {
 
	public String sendCode(String phoneNum, String cd) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G8JpjtV9nWJQrEWucTZ", "p4dVEhGZpyr1Af0CGO40F4KrlCpiWh");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "xiupia");
        request.putQueryParameter("TemplateCode", "SMS_194635450");
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
