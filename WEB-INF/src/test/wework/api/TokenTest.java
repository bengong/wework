package wework.api;

import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

public class TokenTest {

	public static Log log = Logs.get();
	
	public static void main(String[] args) {
		TokenMethods tokenMethods = new TokenMethods();
		
		String corpid = "";
		String corpsecret = "";
		Object result = tokenMethods.gettoken(corpid, corpsecret);
		log.info(Json.toJson(result));		
	}
}
