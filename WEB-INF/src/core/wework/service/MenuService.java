package wework.service;

import org.nutz.ioc.loader.annotation.IocBean;

import wework.Wework;

/**
 * 自定義菜單管理。
 */
@IocBean
public class MenuService {

	/**
	 * 
	 * @param access_token
	 * @param agentid
	 * @return
	 */
	public Object create(String access_token, String agentid, Object data) {
		String url =  String.format(Wework.server_url+"/agent/create?access_token=%s&agentid=%s", access_token, agentid);
		Object result = Wework.postJson(url, data);		
		return result;
	}
	
	/**
	 * 獲取。
	 * 
	 * @param access_token
	 * @param agentid
	 * @return
	 */
	public Object get(String access_token, String agentid) {
		String url =  String.format(Wework.server_url+"/agent/get?access_token=%s&agentid=%s", access_token, agentid); 
		return Wework.get(url);
	}
	
	/**
	 * 获取access_token对应的应用列表
	 * 
	 * @param access_token 调用接口凭证
	 */
	public Object delete(String access_token, String agentid) {
		String url =  String.format(Wework.server_url+"/agent/delete?access_token=%s&agentid=%s", access_token, agentid); 
		return Wework.get(url);
	}
}
