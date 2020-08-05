package wework.module;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Dumps.HTTP;
import org.nutz.lang.random.StringGenerator;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.POST;

import wework.Wework;
import wework.domain.Config;
import wework.util.WXBizMsgCrypt;

/**
 * 回调服务。
 */
@IocBean
@At("callback")
public class CallbackModule {
	@Inject
	public Config config;
	@Inject
	Wework wework;
	
	String token = "1SLa4AMJgF6OP41vHlYI8WEi"; 
	String encodingAesKey = "yInV2hhC7tunsX3tRi22koTUsrYoYQGc9rrQJ8YsO7k";
	String receiveid = "wework";
	WXBizMsgCrypt crypt;
	
	Log log = Logs.get();
	
	public CallbackModule() throws Exception {
		crypt = new WXBizMsgCrypt(token, encodingAesKey, config.corpid);
	}
	
	/**
	 * 创建部门。
	 * @return
	 * @throws Exception 
	 */
	@At({"/"})
	@GET
	public Object get(String msg_signature, String timestamp, String nonce, String echostr) throws Exception {
		return crypt.VerifyURL(msg_signature, timestamp, nonce, echostr);
	}
	
	@At({"/"})
	@POST
	public Object post(String msg_signature, String timestamp, String nonce, HttpServletRequest request) throws Exception {
		// 获取表体的数据。
		String post_data = HTTP.body(request);
		
		String data = crypt.DecryptMsg(msg_signature, timestamp, nonce, post_data);
				
		String reply = data+" 已收到";
		timestamp = ""+System.currentTimeMillis()/1000;
		nonce = new StringGenerator(9,9).next();
		
		String msg_encrypt = crypt.EncryptMsg(reply, timestamp, nonce);
		
		String xml = "<xml>" + "<Encrypt></Encrypt>" + "<MsgSignature></MsgSignature>" + "<TimeStamp></TimeStamp>" + "<Nonce></Nonce>" + "</xml>";
		
		Document document = Parser.xmlParser().parseInput(xml, "");
		document.select("Encrypt").first().text(msg_encrypt);
		document.select("MsgSignature").first().text(msg_encrypt);
		document.select("TimeStamp").first().text(msg_encrypt);
		
		return document.toString();
	}
}