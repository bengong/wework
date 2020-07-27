package wework.service;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.service.Service;

import wework.Wework;

@IocBean
public class DepartmentService  extends Service {	
	
	Log log = Logs.get();

	public DepartmentService() {
		super();
	}
	
	/**
	 * 創建部門。
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Integer create(String access_token, Object data) {		
		String url = String.format(Wework.server_url+"/department/create?access_token=%s", access_token);	
		Object result = Wework.postJson(url, data);	
		
		return (Integer)Mapl.cell(result, "id");
	}
	
	/**
	 * 修改部門。
	 * 
	 * @param access_token
	 * @param data
	 */
	public Object update(String access_token, Object data) {		
		String url = String.format(Wework.server_url+"/department/update?access_token=%s", access_token);
		
		return Wework.postJson(url, data);
	}
	
	/**
	 * 刪除部門。
	 * 
	 * @param access_token
	 * @param id
	 */
	public Object delete(String access_token, String id) {		
		String url = String.format(Wework.server_url+"/department/delete?access_token=%s&id=%s", access_token, id);		
		return Wework.get(url);
	}
	
	/**
	 * 獲取部門清單。
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public List list(String access_token, String id) {		
		String url =  String.format(Wework.server_url+"/department/list?access_token=%s&id=%s", access_token, id);
		Object result = Wework.get(url);
		
		List departments = (List)Mapl.cell(result, "department");
		return departments;
	}
}
