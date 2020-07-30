package wework.api;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mapl.Mapl;

/**
 * 成員服務。
 */
@IocBean
public class UserMethods  extends NutzMethods {
	
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
	public Object get(String userid) {
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
}
