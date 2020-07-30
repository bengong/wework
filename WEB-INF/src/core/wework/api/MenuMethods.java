package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 自定義菜單管理。
 */
@IocBean
public class MenuMethods extends AbstractMethods {
	
	/**
	 * 
	 * @param access_token
	 * @param agentid
	 * @return
	 */
	public Object create(String access_token, String agentid, Object data) {
		String url =  String.format("/agent/create?access_token=%s&agentid=%s", access_token, agentid);
		Object result = postJson(url, data);		
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
		String url =  String.format("/agent/get?access_token=%s&agentid=%s", access_token, agentid); 
		return get(url);
	}
	
	/**
	 * 获取access_token对应的应用列表
	 * 
	 * @param access_token 调用接口凭证
	 */
	public Object delete(String access_token, String agentid) {
		String url =  String.format("/agent/delete?access_token=%s&agentid=%s", access_token, agentid); 
		return get(url);
	}
}
