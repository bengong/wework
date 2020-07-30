package wework.api;

import java.util.HashMap;
import java.util.Map;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

import wework.WeException;

@IocBean
public class CorpMethods  extends AbstractMethods {
	
	public String corpid;	
	/** 其他应用 */
	public Map<String, Object> agents = new HashMap<String, Object>();
	
	Log log = Logs.get();

	public CorpMethods() {
		super();
	}

	/**
	 * 
	 * @param agentid 
	 * @return
	 */
	public String token(String agentid) {
		Object agent = agents.get("agent_"+agentid);
		if(agent == null) {
			throw new WeException(String.format("%s 对应的应用不存在", agentid));
		}
		
		String secret = (String)Mapl.cell(agent, "secret");		
		String access_token = (String)Mapl.cell(agent, "access_token");
		Integer expires_in = (Integer)Mapl.cell(agent, "expires_in");
		Long access_time = (Long)Mapl.cell(agent, "access_time");
		
		long now = System.currentTimeMillis();
		// 如果超时，则重新获取。
		if(access_token == null || (access_time > 0 && now-access_time >= expires_in- 10*1000)) {
			Object result = gettoken(this.corpid, secret);			
			now = System.currentTimeMillis();
			if(result != null) {
				access_time = now;
				access_token = (String)Mapl.cell(result, "access_token");
				expires_in = (Integer)Mapl.cell(result, "expires_in");
				
				Mapl.put(agent, "access_token", access_token);
				Mapl.put(agent, "expires_in", expires_in);
				Mapl.put(agent, "access_time", access_time);
			}
		}
		
		return access_token;
	}
	
	/**
	 * <p>获取access_token是调用企业微信API接口的第一步，相当于创建了一个登录凭证，其它的业务API接口，都需要依赖于access_token来鉴权调用者身份。
	 * 因此开发者，在使用业务接口前，要明确access_token的颁发来源，使用正确的access_token。</p>
	 * 
	 * <p>每个应用有独立的secret，获取到的access_token只能本应用使用，所以每个应用的access_token应该分开来获取</p>
	 * 
	 * @param corpid 公司标识 企业ID，获取方式参考：术语说明-corpid
	 * @param corpsecret  应用的凭证密钥，获取方式参考：术语说明-secret
	 * @return token
	 */
	private Object gettoken(String corpid, String secret) {		
		String url = "/gettoken?corpid=%s&corpsecret=%s";
		
		return get(String.format(url, corpid, secret));
	}
}
