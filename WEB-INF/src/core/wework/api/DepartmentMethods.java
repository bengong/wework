package wework.api;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

@IocBean
public class DepartmentMethods  extends AbstractMethods {
	
	Log log = Logs.get();

	public DepartmentMethods() {
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
		Object result = post(String.format("/department/create?access_token=%s", access_token), data);		
		return (Integer)Mapl.cell(result, "id");
	}
	
	/**
	 * 修改部門。
	 * 
	 * @param access_token
	 * @param data
	 */
	public Object update(String access_token, Object data) {		
		return post(String.format("/department/update?access_token=%s", access_token), data);
	}
	
	/**
	 * 刪除部門。
	 * 
	 * @param access_token
	 * @param id
	 */
	public Object delete(String access_token, String id) {
		return get(String.format("/department/delete?access_token=%s&id=%s", access_token, id));
	}
	
	/**
	 * 獲取部門清單。
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public List list(String access_token, String id) {
		Object result = get(String.format("/department/list?access_token=%s&id=%s", access_token, id));
		return (List)Mapl.cell(result, "department");
	}
}
