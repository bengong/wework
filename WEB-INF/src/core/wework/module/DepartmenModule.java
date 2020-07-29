package wework.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.mvc.annotation.At;

import wework.service.CorpService;
import wework.service.DepartmentService;

/**
 * 部门。
 *
 */
@IocBean
@At("department")
public class DepartmenModule {
	
	String agentid = "contacts";// 通讯录
	
	@Inject
	CorpService corpService;	
	
	@Inject
	DepartmentService departmentService;
	
	Log log = Logs.get();
	
	/**
	 * 创建部门。
	 * @return
	 */
	@At({"/create"})
	public Object create() {		
		NutMap data = new NutMap();		
		Mapl.put(data, "id", "999");
		Mapl.put(data, "name", "广州研发中心");
		Mapl.put(data, "name_en", "RDGZ");
		Mapl.put(data, "parentid", "1");
		
		return departmentService.create(corpService.token(agentid), data);
	}
	
	/**
	 * 更新部門信息。
	 * 
	 * @return
	 */
	@At({"/update"})
	public Object update() {
		Map<String, Object> data = new HashMap<String, Object>();		
		Mapl.put(data, "id", "1");
		Mapl.put(data, "name", "X Funds-xxx");
		Mapl.put(data, "name_en", "X Funds");
		// Mapl.put(data, "parentid", "");
		Mapl.put(data, "order", "100000000");
		
		return departmentService.update(corpService.token(agentid), data);
	}
	
	/**
	 * 刪除部門。
	 * 
	 * @param id 部門標識。
	 * @return
	 */
	@At({"/delete/?"})
	public Object delete(String id) {	
		return departmentService.delete(corpService.token(agentid), id);
	}
	
	@At({"/list", "/list/?"})
	public List list(String id) {
		if(id == null) id = "";
		List result =  departmentService.list(corpService.token(agentid), id);
		
		return result;
	}
}