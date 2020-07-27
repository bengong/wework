package wework.service;

import org.nutz.json.Json;
import org.nutz.lang.Files;

import wework.domain.Token;

public class TokenServiceTest {

	public static void main(String[] args) {
		TokenService service = new TokenService();
		
		String corpid = "";
		String corpsecret = "";
		Token token = service.gettoken(corpid, corpsecret);
		Json.toJsonFile(Files.createFileIfNoExists2("token.json"), token);
	}
}
