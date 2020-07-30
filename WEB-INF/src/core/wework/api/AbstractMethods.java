package wework.api;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

import wework.WeConfig;
import wework.WeException;

public abstract class AbstractMethods {
	@Inject
	protected WeConfig weConfig;

	protected String server_url = "https://qyapi.weixin.qq.com/cgi-bin";
	
	protected int Default_timeout = 60*1000;
	
	protected String agentid;// 通讯录
	
	protected Log log = Logs.get();
	
	public AbstractMethods() {
	}
	
	public AbstractMethods(String agentid) {
		this.agentid = agentid;
	}
	
	/**
	 * GET
	 * 
	 * @param url
	 * @return
	 */
	public abstract Object get(String url);
	
	/**
	 * GET
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public abstract Object get(String url, Map<String, Object> params);
	
	/**
	 * POST。
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public abstract Object post(String url, Object data);
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * 
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public abstract Object post(String url, Object data, int timeout);
    
    /**
     * 上传文件。
     * 
     * @param url
     * @param params
     * @param header
     * @return
     */
    public abstract Object upload(String url, Map<String, Object> params, Header header);
    
    /**
     * 下载。
     * 
     * @param url
     * @return
     */
    public abstract InputStream download(String url);
    
    /**
     * 获取公司主键。
     * 
     * @return corpid
     */
    public String corpid() {
    	return weConfig.corpid;
    }
    
    /**
     * 获取应用。
     * 
     * @param agentid
     * @return agent
     */
    public Object agent(String agentid) {
    	return weConfig.agents.get(agentid);
    }
	
	public String gettoken() {
		return gettoken(agentid);
	}
	
	/**
	 * 获取应用对应的 access_token。
	 * 
	 * @param agentid 应用标识。
	 * 
	 * @return access_token
	 */
	public String gettoken(String agentid) {
		Object agent = agent("agent_"+agentid);
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
			Object result = gettoken(corpid(), secret);			
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
	protected Object gettoken(String corpid, String secret) {
		return get(String.format("/gettoken?corpid=%s&corpsecret=%s", corpid, secret));
	}	
}
