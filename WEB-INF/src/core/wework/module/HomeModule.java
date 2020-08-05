package wework.module;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
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
	public Object login(HttpServletRequest request, ViewModel model) throws UnsupportedEncodingException {
		Context context = Lang.context();
		context.set("basic", "./");
		String corpid = config.corpid;
		String agentid = "1000002";
		
		String scheme = request.getScheme();
		String host = request.getServerName();
		int port = request.getServerPort();
		String contextPath = request.getContextPath();
		
		String redirect_uri =  scheme+"://"+host+":"+port+"/"+contextPath;
		log.info(redirect_uri);
		redirect_uri = URLEncoder.encode("http://macauzone.org/wework", "UTF-8");
		log.info(redirect_uri);
		String href = URLEncoder.encode("http://macauzone.org/wework/css/login.css", "UTF-8");
		
		context.set("appid", corpid);
		context.set("agentid", agentid);
		context.set("redirect_uri", redirect_uri);
		context.set("state", model.get("state"));
		context.set("href", href);
		
		return context;
	}
	
	@At("/test/none")
	public Object none() {
		return "none";
	}
	
	@At("/test/none")
	@RequiresAuthentication
	public Object required() {
		Subject subject = SecurityUtils.getSubject();
		// code為空，則判斷是否已登錄過。如果出錯，則跳轉顯示企業微信二維碼界面。
		// 如发现已登录，则登记地址，并返回。
		String ticket = "";
		if(subject.isAuthenticated()) {
			ticket = (String)subject.getSession().getAttribute("ticket");
			log.infof("ticket = %s", ticket);				
			return "->:/home"; // 返回null, 则代表走默认视图
		}
		
		return "必须为已登录"+ticket;
	}
}
