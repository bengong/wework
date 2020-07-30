package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

import wework.AbstractMethods;

/**
 * 打卡管理。
 */
@IocBean
public class CheckinMethods extends AbstractMethods {
	/**
	 * 获取打卡数据
	 * 
	 * @param access_token 调用接口凭证
	 */
	public Object getcheckindata(String access_token, Object data) {
		// // 调用接口凭证。企业必须使用打卡应用的Secret获取access_token
		String url =  String.format("/checkin/getcheckindata?access_token=%s", access_token);
		
//		请求示例
//		{
//		   "opencheckindatatype": 3, // 打卡类型。1：上下班打卡；2：外出打卡；3：全部打卡
//		   "starttime": 1492617600, // 获取打卡记录的开始时间。Unix时间戳
//		   "endtime": 1492790400, // 获取打卡记录的结束时间。Unix时间戳
//		   "useridlist": ["james","paul"]
//		}
		
		return postJson(url, data);
	}

	/**
	 * 获取打卡规则
	 * 
	 * 用户列表不超过100个，若用户超过100个，请分批获取。
	 * 用户在不同日期的规则不一定相同，请按天获取。
	 * 
	 * @param access_token 调用接口凭证
	 */
	public Object getcheckinoption(String access_token, Object data) {		
		String url =  String.format("/checkin/getcheckinoption?access_token=%s", access_token);
		
//		请求示例
//		{
//		    "datetime": 1511971200,// 需要获取规则的日期当天0点的Unix时间戳
//		    "useridlist": ["james","paul"] // 需要获取打卡规则的用户列表
//		}
		
		return postJson(url, data);
	}
}
