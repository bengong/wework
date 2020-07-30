package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 企业微信公费电话。
 */
@IocBean
public class DialMethods extends NutzMethods {
	
	public DialMethods() {
		super();
	}

	public DialMethods(String agentid) {
		super(agentid);
	}

	/**
	 * 获取公费电话拨打记录
	 * 
	 * 企业可通过此接口，按时间范围拉取成功接通的公费电话拨打记录。
	 * 
	 * 企业需要使用公费电话secret所获取的accesstoken来调用
	 * 
	 * @return
	 */
	public Object get_dial_record(Object data) {
//		请求示例
//		{
//		   "start_time": 1536508800,
//		   "end_time": 1536940800,
//		   "offset": 0,
//		   "limit": 100
//		}
		
		return post(String.format("/dial/get_dial_record?access_token=%s", gettoken()), data);
	}
}
