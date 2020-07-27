package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mapl.Mapl;
import org.nutz.mvc.annotation.At;

import wework.service.MessageService;

/**
 * 消息管理。
 *
 */
@IocBean
@At("message")
public class MessageModule {
	
	@Inject
	MessageService messageService;
	
	@At("/send/?/?")
	public Object send(String access_token) {
		NutMap data = new NutMap();		

		Mapl.put(data, "userid", "zhangsan");
		Mapl.put(data, "name", "张三");
		Mapl.put(data, "alias", "jackzhang");
		Mapl.put(data, "mobile", "+86 13800000000");
		Mapl.put(data, "department", "[1, 2]");
		Mapl.put(data, "order", "[10,40]");
		
		return messageService.send(access_token, data);
	}
}