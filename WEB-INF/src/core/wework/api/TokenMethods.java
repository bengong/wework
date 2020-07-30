package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import wework.AbstractMethods;

@IocBean
public class TokenMethods  extends AbstractMethods {
	
	Log log = Logs.get();

	public TokenMethods() {
		super();
	}

	/**
	 * <p>获取access_token是调用企业微信API接口的第一步，相当于创建了一个登录凭证，其它的业务API接口，都需要依赖于access_token来鉴权调用者身份。
	 * 因此开发者，在使用业务接口前，要明确access_token的颁发来源，使用正确的access_token。</p>
	 * 
	 * <p>每个应用有独立的secret，获取到的access_token只能本应用使用，所以每个应用的access_token应该分开来获取</p>
	 * 
	 * @param corpid 公司标识 企业ID，获取方式参考：术语说明-corpid
	 * @param corpsecret  应用的凭证密钥，获取方式参考：术语说明-secret
	 * @return
	 */
	public Object gettoken(String corpid, String corpsecret) {		
		String url = String.format("/gettoken?corpid=%s&corpsecret=%s", corpid, corpsecret);
		return get(url);
	}
}
