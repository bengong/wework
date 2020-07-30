package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import wework.api.TokenMethods;

@IocBean
@At("token")
public class TokenModule {
	
	@Inject
	TokenMethods tokenMethods;
	
	@At("/gettoken/?/?")
	public Object gettoken(String corpid, String corpsecret) {	
		return tokenMethods.gettoken(corpid, corpsecret);
	}
}