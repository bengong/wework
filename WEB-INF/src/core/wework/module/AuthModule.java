package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;

import wework.Wework;

@IocBean
@At("auth")
public class AuthModule {
	@Inject
	Wework wework;

	Log log = Logs.get();
	
	@At("/")
	public Object home(String code, String state) {
		
		log.info(code);
		log.info(state);
		
		String agentid = "1000002";
		Object userid =  wework.user.getuserinfo(agentid, code);
		log.info(userid);
		
		return userid;
	}

}
