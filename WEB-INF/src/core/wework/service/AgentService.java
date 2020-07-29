package wework.service;

import wework.Wework;

/**
 * 审批。
 */
public class AgentService {
	/**
	 * 获取指定的应用详情
	 * 
	 * @param access_token 调用接口凭证
	 * @param agentid
	 * @return
	 */
	public Object get(String access_token, String agentid) {
		String url =  String.format(Wework.server_url+"/agent/get?access_token=%s&agentid=%s", access_token, agentid); 
		return Wework.get(url);
	}
	
	/**
	 * 设置应用.
	 * 
	 * @param access_token 调用接口凭证
	 * @param data 
	 * @return
	 */
	public Object set(String access_token, Object data) {		
		String url =  String.format(Wework.server_url+"/agent/get?access_token=%s", access_token);
		Object result = Wework.postJson(url, data);		
		return result;
	}
	
	/**
	 * 获取access_token对应的应用列表
	 * 
	 * @param access_token 调用接口凭证
	 */
	public Object list(String access_token) {		
		String url =  String.format(Wework.server_url+"/agent/list?access_token=%s", access_token);
		
		return Wework.get(url);
	}
}
