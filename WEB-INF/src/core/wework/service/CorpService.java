package wework.service;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.service.Service;

import wework.WeException;
import wework.Wework;
import wework.domain.Agent;
import wework.domain.Corp;

@IocBean
public class CorpService  extends Service {	
	@Inject
	public Corp corp;
	
	Log log = Logs.get();

	public CorpService() {
		super();
	}

	public String token(String agentid) {
		Agent agent = corp.agents.get(agentid);
		if(agent == null) {
			throw new WeException(String.format("%s 对应的应用不存在", agentid));
		}
		
		long now = System.currentTimeMillis();
		// 如果超时，则重新获取。
		if(agent.access_token == null || (agent.access_time > 0 && now-agent.access_time >= agent.expires_in- 10*1000)) {
			Object result = gettoken(corp.corpid, agent.secret);			
			now = System.currentTimeMillis();
			if(result != null) {
				agent.access_time = now;
				agent.access_token = (String)Mapl.cell(result, "access_token");
				agent.expires_in = (Integer)Mapl.cell(result, "expires_in");
			}
		}
		
		return agent.access_token;
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
		String url = Wework.server_url+"/gettoken?corpid=%s&corpsecret=%s";
		
		return Wework.get(String.format(url, corpid, secret));
	}
}
