package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import wework.service.AgentService;

/**
 * 應用管理。
 *
 */
@IocBean
@At("agent")
public class AgentModule {
	
	@Inject
	AgentService agentService;
	
	@At("/get/?/?")
	public Object get(String access_token, String agentid) {	
		return agentService.get(access_token, agentid);
	}
	
	@At("/list/?")
	public Object list(String access_token) {
		return agentService.list(access_token);
	}
}