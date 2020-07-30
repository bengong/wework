package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

import wework.AbstractMethods;

/**
 * 企业微信公费电话。
 */
@IocBean
public class DialMethods extends AbstractMethods {
	
	/**
	 * 获取公费电话拨打记录
	 * 
	 * 企业可通过此接口，按时间范围拉取成功接通的公费电话拨打记录。
	 * 
	 * 企业需要使用公费电话secret所获取的accesstoken来调用（<a href="https://work.weixin.qq.com/api/doc/90000/90135/90267#10013/%E7%AC%AC%E4%B8%89%E6%AD%A5%EF%BC%9A%E8%8E%B7%E5%8F%96access_token">accesstoken如何获取？</a>）；
	 * 
	 * @param access_token 调用接口凭证
	 * @return
	 */
	public Object get_dial_record(String access_token, Object data) {
		String url =  String.format("/dial/get_dial_record?access_token=%s", access_token);
		
//		请求示例
//		{
//		   "start_time": 1536508800,
//		   "end_time": 1536940800,
//		   "offset": 0,
//		   "limit": 100
//		}
		
		return postJson(url, data);
	}
}
