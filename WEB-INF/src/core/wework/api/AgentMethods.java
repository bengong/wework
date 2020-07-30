package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 审批。
 */
@IocBean
public class AgentMethods extends AbstractMethods {

	/**
	 * 获取指定的应用详情
	 * 
	 * @param agentid
	 * @return
	 */
	public Object get(String access_token, String agentid) {
		return get(String.format("/agent/get?access_token=%s&agentid=%s", access_token, agentid));
	}
	
	/**
	 * 设置应用.
	 * 
	 * @param access_token 调用接口凭证
	 * @param data 
	 * @return
	 */
	public Object set(String access_token, Object data) {
		return post(String.format("/agent/get?access_token=%s", access_token), data);
	}
	
	/**
	 * 获取access_token对应的应用列表
	 * 
	 * @param access_token 调用接口凭证
	 */
	public Object list(String access_token) {
		return get(String.format("/agent/list?access_token=%s", access_token));
	}
}
