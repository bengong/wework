package wework.module;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;

import wework.Wework;
import wework.domain.Config;

@IocBean
@At("auth")
public class AuthTestModule {
	@Inject
	public Config config;
	@Inject
	Wework wework;

	Log log = Logs.get();
	
	@At("/none")
	public Object none() {
		return "none";
	}
	
	@At("/required")
	@RequiresAuthentication
	public Object required() {
		Subject subject = SecurityUtils.getSubject();
		// code為空，則判斷是否已登錄過。如果出錯，則跳轉顯示企業微信二維碼界面。
		// 如发现已登录，则登记地址，并返回。
		String ticket = "";
		if(subject.isAuthenticated()) {
			ticket = (String)subject.getSession().getAttribute("ticket");
			log.infof("ticket = %s", ticket);				
		}
		
		return "必须为已登录"+ticket;
	}
}
