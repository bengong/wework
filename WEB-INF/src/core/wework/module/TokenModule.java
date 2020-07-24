package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import wework.service.TokenService;

@IocBean
@At("token")
public class TokenModule {
	
	@Inject
	TokenService tokenService;
	
	@At("/gettoken/?/?")
	public Object gettoken(String corpid, String corpsecret) {	
		return tokenService.gettoken(corpid, corpsecret);
	}
}