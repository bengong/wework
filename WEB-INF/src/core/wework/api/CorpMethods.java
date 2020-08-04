package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 公司管理。
 */
@IocBean(name="corp")
public class CorpMethods extends AbstractMethods {
	
	public CorpMethods() {
		super();
	}

	public CorpMethods(String agentid) {
		super(agentid);
	}

	/**
	 * 
	 * @param size_type qrcode尺寸类型，1: 171 x 171; 2: 399 x 399; 3: 741 x 741; 4: 2052 x 2052
	 * @return
	 */
	public Object get_join_qrcode(String size_type) {
//		请求示例
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "join_qrcode": "https://work.weixin.qq.com/wework_admin/genqrcode?action=join&vcode=3db1fab03118ae2aa1544cb9abe84&r=hb_share_api_mjoin&qr_size=3" // 二维码链接，有效期7天
//		}
		
		return get(String.format("/checkin/getcheckindata?access_token=%s", gettoken(), size_type));
	}

	/**
	 * 获取打卡规则
	 * 
	 * 用户列表不超过100个，若用户超过100个，请分批获取。
	 * 用户在不同日期的规则不一定相同，请按天获取。
	 * 
	 * 
	 */
	public Object getcheckinoption(Object data) {		
//		请求示例
//		{
//		    "datetime": 1511971200,// 需要获取规则的日期当天0点的Unix时间戳
//		    "useridlist": ["james","paul"] // 需要获取打卡规则的用户列表
//		}
		
		return post(String.format("/checkin/getcheckinoption?access_token=%s", gettoken()), data);
	}
}
