package wework;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// 链接地址一：直接打开
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=%s#wechat_redirect";
		String appid = "wwea1a491e1639ecd6";
		String redirect_uri = URLEncoder.encode("http://macauzone.org/wework/auth/", "UTF-8");
		String state = "";
		String encoding_uri = String.format(url, appid, redirect_uri, state);
		System.out.println(encoding_uri);
		
		
		// 链接地址二：使用二维码打开。
		String agentid = "1000002";
		url = "https://open.work.weixin.qq.com/wwopen/sso/qrConnect?appid=%s&agentid=%s&redirect_uri=%s&state=%s";	
		encoding_uri = String.format(url, appid, agentid, redirect_uri, state);
		System.out.println(encoding_uri);		
	}
}
