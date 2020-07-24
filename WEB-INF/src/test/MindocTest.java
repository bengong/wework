import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.nutz.http.Http;

import com.sun.net.ssl.HostnameVerifier;
import com.sun.net.ssl.HttpsURLConnection;

public class MindocTest {

	public static void main(String[] args) throws Exception {
        Http.disableJvmHttpsCheck();
        
        login("bengong", "icbc@2018");
	}
	
	private static void login(String account, String password) {
		String url = "https://macauzone.org/x-funds/login";
		
		Http.get("https://macauzone.org/x-funds/logout");		
		Object content =  Http.get(url).getContent();
		System.out.println(content);		
		String _xsrf = Jsoup.parse(content.toString()).select("[name=_xsrf]").first().attr("value");
		
		Map<String, Object> params =new HashMap<String, Object>();		
		params.put("_xsrf", _xsrf);
		params.put("account", account);
		params.put("password", password);
		params.put("remember", "yes");
		
		String result =  Http.post("https://macauzone.org/x-funds/login?url=https:%2F%2Fmacauzone.org%2Fx-funds%2F",  params, 30*1000);		
		System.out.println(result);
		
		
	}

	/**
	 * 
	 * @param identify
	 */
	private static void release(String identify) {
		String url = "http://macauzone.org/x-funds/book/topic/release";
		
		Map<String, Object> params =new HashMap<String, Object>();
		// identify=topic
		params.put("identify", identify);
		
		String result =  Http.post(url, params, 30*1000);
		System.out.println(result);
	}
}
