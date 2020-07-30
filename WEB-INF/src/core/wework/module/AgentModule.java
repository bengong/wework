package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import wework.WeWork;

/**
 * 應用管理。
 *
 */
@IocBean
@At("agent")
public class AgentModule {
	
	@Inject
	WeWork weWork;
	
	/**
	 * 获取指定的应用详情
	 * 
	 * @param access_token 调用接口凭证
	 * @param agentid 应用id
	 * @return
	 */
	@At("/get/?/?")
	public Object get(String access_token, String agentid) {	
		return weWork.agentMethods.get(access_token, agentid);
	}
	
	/**
	 * 获取access_token对应的应用列表
	 * 
	 * @param access_token 调用接口凭证
	 * @return
	 */
	@At("/list/?")
	public Object list(String access_token) {
		return weWork.agentMethods.list(access_token);
	}
}