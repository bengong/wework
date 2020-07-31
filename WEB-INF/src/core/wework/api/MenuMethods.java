package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 自定義菜單管理。
 */
@IocBean(name="menu")
public class MenuMethods extends AbstractMethods {
	
	public MenuMethods() {
		super();
	}

	public MenuMethods(String agentid) {
		super(agentid);
	}

	/**
	 * 
	 * @param agentid
	 * @return
	 */
	public Object create(String agentid, Object data) {
		Object result = post(String.format("/agent/create?access_token=%s&agentid=%s", gettoken(), agentid), data);		
		return result;
	}
	
	/**
	 * 獲取。
	 * 
	 * @param agentid
	 * @return
	 */
	public Object get(String agentid) {
		return get(String.format("/agent/get?access_token=%s&agentid=%s", gettoken(), agentid));
	}
	
	/**
	 * 获取access_token对应的应用列表
	 * 
	 * @param agentid
	 * @return
	 */
	public Object delete(String agentid) {
		return get(String.format("/agent/delete?access_token=%s&agentid=%s", gettoken(), agentid));
	}
}
