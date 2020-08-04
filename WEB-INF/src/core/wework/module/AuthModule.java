package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.util.Context;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import wework.Wework;

@IocBean
@At("auth")
public class AuthModule {
	@Inject
	Wework wework;

	Log log = Logs.get();
	
	@At("/")
	@Ok("jsp:/demo/index")
	public Object home(String code, String state) {
		Context context = Lang.context();
		
		String agentid = "1000002";
		Object userid = null;
		try {
			userid = wework.user.getuserinfo(agentid, code);
		} catch (Exception e) {
			log.error(e);
		}
		
		context.set("userid", userid);
		
		return context;
	}

}
