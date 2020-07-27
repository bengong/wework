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
public class TagService  extends Service {	
	
	Log log = Logs.get();

	public TagService() {
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
		String url = String.format(Wework.server_url+"/tag/create?access_token=%s", access_token);	
		Object result = Wework.postJson(url, data);		
		return (Integer)Mapl.cell(result, "tagid");
	}
	
	/**
	 * 更新标签名字
	 * 
	 * @param access_token
	 * @param data
	 */
	public Object update(String access_token, Object data) {		
		String url = String.format(Wework.server_url+"/tag/update?access_token=%s", access_token);
		
		return Wework.postJson(url, data);
	}
	
	/**
	 * 刪除。
	 * 
	 * @param access_token
	 * @param tagid
	 */
	public Object delete(String access_token, String tagid) {		
		String url = String.format(Wework.server_url+"/tag/delete?access_token=%s&tagid=%s", access_token, tagid);		
		return Wework.get(url);
	}

	/**
	 * 获取标签成员
	 * 
	 * @param access_token
	 * @param tagid
	 * @return
	 */
	public Object get(String access_token, String tagid) {		
		String url =  String.format(Wework.server_url+"/tag/get?access_token=%s&tagid=%s", access_token, tagid);
		return Wework.get(url);
	}
	
	/**
	 * 增加标签成员
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Object addtagusers(String access_token, Object data) {		
		String url = String.format(Wework.server_url+"/tag/addtagusers?access_token=%s", access_token);
		
		return Wework.postJson(url, data);
	}
	
	/**
	 * 删除标签成员
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Object deltagusers(String access_token, Object data) {		
		String url = String.format(Wework.server_url+"/tag/deltagusers?access_token=%s", access_token);
		
		return Wework.postJson(url, data);
	}
	
	
	
	/**
	 * 获取标签列表
	 * 
	 * @param access_token 调用接口凭证
	 * @return taglist
	 */
	public List list(String access_token, String department_id, String fetch_child) {		
		String url =  String.format(Wework.server_url+"/tag/list?access_token=%s", access_token);
		Object result = Wework.get(url);
		List taglist = (List)Mapl.cell(result, "taglist");
		return taglist;
	}
}
