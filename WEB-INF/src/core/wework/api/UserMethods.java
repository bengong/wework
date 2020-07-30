package wework.api;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mapl.Mapl;

/**
 * 成員服務。
 */
@IocBean
public class UserMethods  extends AbstractMethods {
	
	/**
	 * 創建。
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Integer create(String access_token, Object data) {
		Object result = post(String.format("/user/create?access_token=%s", access_token), data);		
		return (Integer)Mapl.cell(result, "id");
	}
	
	/**
	 * 修改。
	 * 
	 * @param access_token
	 * @param data
	 */
	public Object update(String access_token, Object data) {
		return post(String.format("/user/update?access_token=%s", access_token), data);
	}
	
	/**
	 * 刪除。
	 * 
	 * @param access_token
	 * @param userid
	 */
	public Object delete(String access_token, String userid) {
		return get(String.format("/user/delete?access_token=%s&userid=%s", access_token, userid));
	}
	
	/**
	 * 批量删除
	 * 
	 * @param access_token 调用接口凭证
	 * @param useridlist 成员UserID列表。对应管理端的帐号。最多支持200个。若存在无效UserID，直接返回错误
	 * @return
	 */
	public Object batchdelete(String access_token, Object useridlist) {
		return post(String.format("/user/batchdelete?access_token=%s&id=%s", access_token), useridlist);
	}
	
	/**
	 * 获取
	 * 
	 * @param access_token
	 * @param userid
	 * @return
	 */
	public Object get(String access_token, String userid) {
		return get(String.format("/user/get?access_token=%s&userid=%s", access_token, userid));
	}
	
	/**
	 * 获取部门成员
	 * 
	 * @param access_token 调用接口凭证
	 * @param department_id 获取的部门id
	 * @param fetch_child 是否递归获取子部门下面的成员：1-递归获取，0-只获取本部门
	 * @return userlist
	 */
	public List simplelist(String access_token, String department_id, String fetch_child) {
		Object result = get(String.format("/user/list?access_token=%s&department_id=%s&fetch_child=%s", access_token, department_id, fetch_child));
		return (List)Mapl.cell(result, "userlist");
	}
	
	/**
	 * 获取部门成员详情
	 * 
	 * @param access_token 调用接口凭证
	 * @param department_id 获取的部门id
	 * @param fetch_child 是否递归获取子部门下面的成员：1-递归获取，0-只获取本部门
	 * @return userlist
	 */
	public List list(String access_token, String department_id, String fetch_child) {
		Object result = get(String.format("/user/list?access_token=%s&department_id=%s&fetch_child=%s", access_token, department_id, fetch_child));
		return (List)Mapl.cell(result, "department");
	}
}
