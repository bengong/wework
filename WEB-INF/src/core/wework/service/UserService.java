package wework.service;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.service.Service;

import wework.Wework;

/**
 * 成員服務。
 */
@IocBean
public class UserService  extends Service {	
	
	Log log = Logs.get();

	public UserService() {
		super();
	}
	
	/**
	 * 創建。
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Integer create(String access_token, Object data) {		
		String url = String.format(Wework.server_url+"/user/create?access_token=%s", access_token);	
		Object result = Wework.postJson(url, data);		
		return (Integer)Mapl.cell(result, "id");
	}
	
	/**
	 * 修改。
	 * 
	 * @param access_token
	 * @param data
	 */
	public Object update(String access_token, Object data) {		
		String url = String.format(Wework.server_url+"/user/update?access_token=%s", access_token);
		
		return Wework.postJson(url, data);
	}
	
	/**
	 * 刪除。
	 * 
	 * @param access_token
	 * @param userid
	 */
	public Object delete(String access_token, String userid) {		
		String url = String.format(Wework.server_url+"/user/delete?access_token=%s&userid=%s", access_token, userid);		
		return Wework.get(url);
	}
	
	/**
	 * 批量删除
	 * 
	 * @param access_token 调用接口凭证
	 * @param useridlist 成员UserID列表。对应管理端的帐号。最多支持200个。若存在无效UserID，直接返回错误
	 * @return
	 */
	public Object batchdelete(String access_token, Object useridlist) {		
		String url = String.format(Wework.server_url+"/user/batchdelete?access_token=%s&id=%s", access_token);		
		
		return Wework.postJson(url, useridlist);
	}
	
	/**
	 * 获取
	 * 
	 * @param access_token
	 * @param userid
	 * @return
	 */
	public Object get(String access_token, String userid) {		
		String url =  String.format(Wework.server_url+"/user/get?access_token=%s&userid=%s", access_token, userid);
		return Wework.get(url);
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
		String url =  String.format(Wework.server_url+"/user/list?access_token=%s&department_id=%s&fetch_child=%s", access_token, department_id, fetch_child);
		Object result = Wework.get(url);
		
		List userlist = (List)Mapl.cell(result, "userlist");
		return userlist;
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
		String url =  String.format(Wework.server_url+"/user/list?access_token=%s&department_id=%s&fetch_child=%s", access_token, department_id, fetch_child);
		Object result = Wework.get(url);
		List departments = (List)Mapl.cell(result, "department");
		return departments;
	}
}