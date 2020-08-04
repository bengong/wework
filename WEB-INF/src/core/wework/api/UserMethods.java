package wework.api;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mapl.Mapl;

/**
 * 成員服務。
 */
@IocBean(name="user")
public class UserMethods  extends AbstractMethods {
	
	public UserMethods() {
		super();
	}

	public UserMethods(String agentid) {
		super(agentid);
	}

	/**
	 * 創建。
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Integer create(Object data) {
		Object result = post(String.format("/user/create?access_token=%s", gettoken()), data);		
		return (Integer)Mapl.cell(result, "id");
	}
	
	/**
	 * 修改。
	 * 
	 * 
	 * @param data
	 */
	public Object update(Object data) {
		return post(String.format("/user/update?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 刪除。
	 * 
	 * 
	 * @param userid
	 */
	public Object delete(String userid) {
		return get(String.format("/user/delete?access_token=%s&userid=%s", gettoken(), userid));
	}
	
	/**
	 * 批量删除
	 * 
	 *  调用接口凭证
	 * @param useridlist 成员UserID列表。对应管理端的帐号。最多支持200个。若存在无效UserID，直接返回错误
	 * @return
	 */
	public Object batchdelete(Object useridlist) {
		return post(String.format("/user/batchdelete?access_token=%s&id=%s", gettoken()), useridlist);
	}
	
	/**
	 * 获取
	 * 
	 * 
	 * @param userid
	 * @return
	 */
	public Object getuserinfo(String userid) {
		return get(String.format("/user/get?access_token=%s&userid=%s", gettoken(), userid));
	}
	
	/**
	 * 获取部门成员
	 * 
	 *  
	 * @param department_id 获取的部门id
	 * @param fetch_child 是否递归获取子部门下面的成员：1-递归获取，0-只获取本部门
	 * @return userlist
	 */
	public List simplelist(String department_id, String fetch_child) {
		Object result = get(String.format("/user/list?access_token=%s&department_id=%s&fetch_child=%s", gettoken(), department_id, fetch_child));
		return (List)Mapl.cell(result, "userlist");
	}
	
	/**
	 * 获取部门成员详情
	 * 
	 *  
	 * @param department_id 获取的部门id
	 * @param fetch_child 是否递归获取子部门下面的成员：1-递归获取，0-只获取本部门
	 * @return userlist
	 */
	public List list(String department_id, String fetch_child) {
		Object result = get(String.format("/user/list?access_token=%s&department_id=%s&fetch_child=%s", gettoken(), department_id, fetch_child));
		return (List)Mapl.cell(result, "department");
	}
	
	
	/**
	 * userid转openid
	 * 
	 * 该接口使用场景为企业支付，在使用企业红包和向员工付款时，需要自行将企业微信的userid转成openid。
	 * 
	 * 注：需要成员使用微信登录企业微信或者关注微工作台（原企业号）才能转成openid;
	 * 如果是外部联系人，请使用外部联系人openid转换转换openid

	 * @param data
	 * @return
	 */
	public String convert_to_openid(Object data) {
		Object result = post(String.format("/user/convert_to_openid?access_token=%s", gettoken()), data);
		return (String)Mapl.cell(result, "openid");
	}
	
	/**
	 * <p>二次验证</p>
	 * 
	 * <p>此接口可以满足安全性要求高的企业进行成员验证。开启二次验证后，当且仅当成员登录时，需跳转至企业自定义的页面进行验证。验证频率可在设置页面选择。</p>
	 * 
	 * <p>
	 * 企业在开启二次验证时，必须在管理端填写企业二次验证页面的url。
	 * 当成员登录企业微信或关注微工作台（原企业号）进入企业时，会自动跳转到企业的验证页面。在跳转到企业的验证页面时，会带上如下参数：code=CODE。
	 * 企业收到code后，使用“通讯录同步助手”调用接口“根据code获取成员信息”获取成员的userid。
	 * 如果成员是首次加入企业，企业获取到userid，并验证了成员信息后，调用如下接口即可让成员成功加入企业。
	 * </p>
	 * 
	 * @param userid
	 * @return
	 */
	public String authsucc(String userid) {
		Object result = post(String.format("/user/authsucc?access_token=%s&userid=%s", gettoken()), userid);
		return (String)Mapl.cell(result, "openid");
	}
	
	/**
	 * 获取企业活跃成员数
	 * 
	 * @param userid
	 * @return
	 */
	public String get_active_stat(String userid) {
//		
//		{
//		    "date": "2020-03-27"
//		}
		
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "active_cnt": 100
//		}
		
		Object result = post(String.format("/user/get_active_stat?access_token=%s&userid=%s", gettoken()), userid);
		return (String)Mapl.cell(result, "openid");
	}
	
	/**
	 * 获取访问用户身份
	 * 
	 * 该接口用于根据code获取成员信息
	 * 
	 * @param code
	 * @return
	 */
	public Object getuserinfo(String agentid, String code) {
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "UserId":"USERID",// 成员UserID。若需要获得用户详情信息，可调用通讯录接口：读取成员。如果是互联企业，则返回的UserId格式如：CorpId/userid
//		   "DeviceId":"DEVICEID" // 手机设备号(由企业微信在安装时随机生成，删除重装会改变，升级不受影响)
//		}
		
		return get(String.format("/user/getuserinfo?access_token=%s&code=%s", gettoken(agentid), code));
	}
}
