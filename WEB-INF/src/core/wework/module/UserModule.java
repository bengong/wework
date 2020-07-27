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
import wework.service.UserService;

@IocBean
@At("user")
public class UserModule {
	
	String agentid = "contacts";
	
	@Inject
	CorpService corpService;	
	
	@Inject
	UserService userService;
	
	Log log = Logs.get();
	
	@At({"/create"})
	public Object create() {		
		NutMap data = new NutMap();		

		Mapl.put(data, "userid", "zhangsan");
		Mapl.put(data, "name", "张三");
		Mapl.put(data, "alias", "jackzhang");
		Mapl.put(data, "mobile", "+86 13800000000");
		Mapl.put(data, "department", "[1, 2]");
		Mapl.put(data, "order", "[10,40]");
		Mapl.put(data, "position", "产品经理");
		Mapl.put(data, "gender", 1);
		Mapl.put(data, "email", "zhangsan@gzdev.com");
		Mapl.put(data, "is_leader_in_dept", "[1, 0]");
		Mapl.put(data, "enable", 1);
		Mapl.put(data, "avatar_mediaid", "2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0");
		Mapl.put(data, "telephone", "020-123456");
		Mapl.put(data, "address", "广州市海珠区新港中路");
		Mapl.put(data, "main_department", 1);
		int i = 0;
		Mapl.put(data, "extattr.attrs[" + i + "].type", 0);
		Mapl.put(data, "extattr.attrs[" + i + "].name", "文本名称");
		Mapl.put(data, "extattr.attrs[" + i + "].text.value", "文本");

		i++;
		Mapl.put(data, "extattr.attrs[" + i + "].type", 1);
		Mapl.put(data, "extattr.attrs[" + i + "].name", "网页名称");
		Mapl.put(data, "extattr.attrs[" + i + "].web.url", "文本");
		Mapl.put(data, "extattr.attrs[" + i + "].web.title", "标题");

		Mapl.put(data, "to_invite", true);
		Mapl.put(data, "external_position", "高级产品经理");

		Mapl.put(data, "external_profile.external_corp_name", "企业简称");

		i = 0;
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].type", 0);
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].name", "文本名称");
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].text.value", "文本");

		i++;
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].type", 1);
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].name", "网页名称");
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].web.url", "http://www.test.com");
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].web.title", "标题");

		i++;
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].type", 2);
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].name", "测试app");
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].miniprogram.appid",
				"wx8bd8012614784fake");
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].miniprogram.pagepath", "/index");
		Mapl.put(data, "external_profile.external_profile.external_attr[" + i + "].miniprogram.title", "my miniprogram");
		
		return userService.create(corpService.token(agentid), data);
	}
	
	/**
	 * 
	 * @return
	 */
	@At({"/update"})
	public Object update() {
		Map<String, Object> data = new HashMap<String, Object>();
		
		Mapl.put(data, "userid", "zhangsan");
		Mapl.put(data, "name", "张三-xxxx");
		Mapl.put(data, "alias", "jackzhang");
		Mapl.put(data, "mobile", "+86 13800000000");
		Mapl.put(data, "department", "[1, 2]");
		Mapl.put(data, "order", "[10,40]");
		Mapl.put(data, "position", "产品经理");
		Mapl.put(data, "gender", 1);
		Mapl.put(data, "email", "zhangsan@gzdev.com");
		Mapl.put(data, "is_leader_in_dept", "[1, 0]");
		Mapl.put(data, "enable", 1);
		Mapl.put(data, "avatar_mediaid", "2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0");
		Mapl.put(data, "telephone", "020-123456");
		Mapl.put(data, "address", "广州市海珠区新港中路");
		Mapl.put(data, "main_department", 1);
		int i = 0;
		Mapl.put(data, "extattr.attrs["+i+"].type", 0);
		Mapl.put(data, "extattr.attrs["+i+"].name", "文本名称");
		Mapl.put(data, "extattr.attrs["+i+"].text.value", "文本");
		
		i++;
		Mapl.put(data, "extattr.attrs["+i+"].type", 1);
		Mapl.put(data, "extattr.attrs["+i+"].name", "网页名称");
		Mapl.put(data, "extattr.attrs["+i+"].web.url", "文本");
		Mapl.put(data, "extattr.attrs["+i+"].web.title", "标题");
		
		Mapl.put(data, "to_invite", true);
		Mapl.put(data, "external_position", "高级产品经理");
		
		Mapl.put(data, "external_profile.external_corp_name", "企业简称");
		
		i = 0;
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].type", 0);
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].name", "文本名称");
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].text.value", "文本");

		i++;
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].type", 1);
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].name", "网页名称");
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].web.url", "http://www.test.com");
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].web.title", "标题");

		i++;
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].type", 2);
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].name", "测试app");
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].miniprogram.appid", "wx8bd8012614784fake");
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].miniprogram.pagepath", "/index");
		Mapl.put(data, "external_profile.external_profile.external_attr["+i+"].miniprogram.title", "my miniprogram");
		
		return userService.update(corpService.token(agentid), data);
	}

	@At({"/get/?"})
	public Object get(String userid) {	
		return userService.get(corpService.token(agentid), userid);
	}
	
	/**
	 * 删除成员。
	 * 
	 * @param userid
	 * @return
	 */
	@At({"/delete/?"})
	public Object delete(String userid) {	
		return userService.delete(corpService.token(agentid), userid);
	}
	
	
	@At({"/simplelist/?/?"})
	public List simplelist(String department_id, String fetch_child) {
		List result =  userService.simplelist(corpService.token(agentid), department_id, fetch_child);
		
		return result;
	}
	
	@At({"/list/?/?"})
	public List list(String department_id, String fetch_child) {
		List result =  userService.list(corpService.token(agentid), department_id, fetch_child);
		
		return result;
	}
}