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
		super("contacts");// 通讯录
	}
	
	/**
	 * 創建部門。
	 * 
	 * @param data
	 * @return
	 */
	public Integer create(Object data) {
		Object result = post(String.format("/department/create?access_token=%s", gettoken()), data);		
		return (Integer)Mapl.cell(result, "id");
	}
	
	/**
	 * 修改部門。
	 * 
	 * @param data
	 */
	public Object update(Object data) {
		return post(String.format("/department/update?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 刪除部門。
	 * 
	 * @param id
	 */
	public Object delete(String id) {
		return get(String.format("/department/delete?access_token=%s&id=%s", gettoken(), id));
	}
	
	/**
	 * 獲取部門清單。
	 * 
	 * @param data
	 * @return
	 */
	public List list(String id) {
		Object result = get(String.format("/department/list?access_token=%s&id=%s", gettoken(), id));
		return (List)Mapl.cell(result, "department");
	}
}
