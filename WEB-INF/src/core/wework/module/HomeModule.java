package wework.module;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.util.Context;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ViewModel;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import wework.Wework;
import wework.domain.Config;

@IocBean
@At("home")
public class HomeModule {
	@Inject
	public Config config;
	@Inject
	Wework wework;

	Log log = Logs.get();
	
	@At("/")
	@Ok("jsp:/home/index")
	public Object home() {
		Context context = Lang.context();
		context.set("basic", "./");
		
		return context;
	}

	/**
	 * 登录。显示企业微信登录二维码。
	 * 
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@At("/login")
	@Ok("jsp:/home/login")
	public Object login(ViewModel model) throws UnsupportedEncodingException {
		Context context = Lang.context();
		context.set("basic", "./");
		String corpid = config.corpid;
		String agentid = "1000002";
		String redirect_uri = URLEncoder.encode("http://macauzone.org/wework/home/", "UTF-8");		
		String href = URLEncoder.encode("http://macauzone.org/wework/css/login.css", "UTF-8");
		
		context.set("appid", corpid);
		context.set("agentid", agentid);
		context.set("redirect_uri", redirect_uri);
		context.set("state", model.get("state"));
		context.set("href", href);
		
		return context;
	}
}