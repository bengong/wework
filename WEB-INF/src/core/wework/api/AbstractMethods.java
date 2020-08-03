package wework.api;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

import wework.domain.Config;
import wework.util.BusinessException;
import wework.util.NutPostman;
import wework.util.Postman;

public abstract class AbstractMethods {
	@Inject
	public Config config;
	@Inject
	public Postman postman = new NutPostman();
	
	protected String server_url = "https://qyapi.weixin.qq.com/cgi-bin";
	
	protected String agentid;
	
	protected Log log = Logs.get();
	
	public AbstractMethods() {
	}
	
	public AbstractMethods(String agentid) {
		this.agentid = agentid;
	}
	
	protected final Object get(String url) {
		return  postman.get(server_url+url);
    }
	
	protected final Object get(String url, Map<String, Object> params) {
		return postman.get(server_url+url, params);
    }
	
	protected final Object post(String url, Object data) {		
        return postman.post(server_url+url, data);
    }
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * 
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
	protected final Object post(String url, Object data, int timeout) {
        return postman.post(server_url+url, data);
    }    
    
    /**
     * 上传文件。
     * 
     * @param url
     * @param params
     * @param header
     * @return
     */
    protected final Object upload(String url, Map<String, Object> params, Header header) {
    	return postman.upload(server_url+url, params, header);
    }
    
    protected final InputStream download(String url) {
    	return postman.download(server_url+url);
    }    
    
    /**
     * 获取应用。
     * 
     * @param agentid
     * @return agent
     */
    protected Object agent(String agentid) {
    	return config.agents.get(agentid);
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
		Object agent = agent(agentid);
		// 不存在的应用。
		if(agent == null) {
			throw new BusinessException(String.format("%s 对应的应用不存在", agentid));
		}
		
		String secret = (String)Mapl.cell(agent, "secret");		
		String access_token = (String)Mapl.cell(agent, "access_token");
		Integer expires_in = (Integer)Mapl.cell(agent, "expires_in");
		Long access_time = (Long)Mapl.cell(agent, "access_time");
		
		long now = System.currentTimeMillis();
		// 如果超时，则重新获取。
		if(access_token == null || (access_time > 0 && now-access_time >= expires_in- 10*1000)) {
			Object result = gettoken(config.corpid, secret);			
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
	
	/**
	 * 获取企业微信API域名IP段
	 * 
	 * API域名IP即qyapi.weixin.qq.com的解析地址，由开发者调用企业微信侧的接入IP。如果企业需要做防火墙配置，那么可以通过这个接口获取到所有相关的IP段。
	 * IP段有变更可能，当IP段变更时，新旧IP段会同时保留一段时间。建议企业每天定时拉取IP段，更新防火墙设置，避免因IP段变更导致网络不通。
	 * 
	 * @param access_token
	 * @return
	 */
	protected Object get_api_domain_ip(String access_token) {
		
//		{
//		    "ip_list":[
//		        "182.254.11.176",
//		        "182.254.78.66"
//		    ],
//		    "errcode":0,
//		    "errmsg":"ok"
//		}
		
		return get(String.format("/get_api_domain_ip?access_token=%s", access_token));
	}
	
}
