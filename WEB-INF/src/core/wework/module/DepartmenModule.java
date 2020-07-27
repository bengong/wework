package wework.module;

import java.util.HashMap;
import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mapl.Mapl;
import org.nutz.mvc.annotation.At;

import wework.service.CorpService;
import wework.service.DepartmentService;

@IocBean
@At("department")
public class DepartmenModule {
	
	String agentid = "contacts";
	
	@Inject
	CorpService corpService;	
	
	@Inject
	DepartmentService departmentService;
	
	@At({"/create"})
	public Object create(String id) {
		Map<String, Object> map = new HashMap<String, Object>();		
		Mapl data = (Mapl)Mapl.toMaplist(map);
		
		Mapl.put(data, "name", "广州研发中心");
		Mapl.put(data, "name_en", "RDGZ");
		Mapl.put(data, "parentid", "1");
		Mapl.put(data, "order", "1");
		Mapl.put(data, "id", "");
		
		return departmentService.create(corpService.token(agentid), data);
	}
	
	@At({"/list", "/list/?"})
	public Object list(String id) {
		return departmentService.list(corpService.token(agentid), id);
	}
}