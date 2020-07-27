package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import wework.service.TokenService;

@IocBean
@At("token-test")
public class TokenModuleTest {
	
	@Inject
	TokenService tokenService;
	
	@At("/gettoken")
	public Object gettoken() {
		String corpid = "wwea1a491e1639ecd6";
		String corpsecret = "dfGh-do1kJ_uUS168NBG4dsXyOkYPeHJpqUIVBG52ys";
		
		return tokenService.gettoken(corpid, corpsecret);
	}
}