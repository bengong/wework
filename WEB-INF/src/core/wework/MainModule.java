package wework;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.random.StringGenerator;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.mvc.ViewModel;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.mvc.view.DefaultViewMaker;

import wework.domain.UsernameTicketToken;
import wework.service.UserService;
import wework.util.BusinessException;
import wework.util.Result;

/**
 * 主模块。
 */
@Modules(scanPackage = true)
@Views({ DefaultViewMaker.class})
@IocBy(type = ComboIocProvider.class, args = {"*org.nutz.ioc.loader.json.JsonLoader", "core.js", "*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "wework"})
@SetupBy(DefaultSetup.class)
@Ok("raw")
@Fail("raw")
@Localization(value="i18n") 
@IocBean
public class MainModule {
	@Inject
	Wework wework;
	@Inject
	UserService userService;
	
	Log log = Logs.get();
	
	@At("/")
	@Ok("re")
	public Object index(String code, String state, ViewModel model) {
		String agentid = "1000002";		
		log.infof("code = %s", code);

		String ticket = code;
		Subject subject = SecurityUtils.getSubject();
		// code為空，則判斷是否已登錄過。如果出錯，則跳轉顯示企業微信二維碼界面。
		if(code == null || code.trim().equals("")) {
			// 如发现已登录，则登记地址，并返回。
			if(subject.isAuthenticated()) {
				ticket = (String)subject.getSession().getAttribute("ticket");
				log.infof("ticket = %s", ticket);				
				return ">>:/home"; // 返回null, 则代表走默认视图
			}
		} else {
			try {
				Object userinfo = wework.user.getuserinfo(agentid, code);
				if(!Lang.isEmpty(userinfo)) {
					String userid = (String)Mapl.cell(userinfo, "UserId");
					log.infof("userid = %s", userid);
					UsernameTicketToken token = new UsernameTicketToken(userid, ticket);
				    token.setRememberMe(true);
			        // 更新票根。
			       userService.updateTicket(userid, ticket);
			    	
			        subject.login(token);
			        subject.getSession().setAttribute("ticket", ticket);
				}
				return ">>:/home"; // 返回null, 则代表走默认视图
			} catch (BusinessException e) {
				log.error(e);			
			}
		}
		
		return "->:/home/login";
	}
	
	/**
	 * demo 演示以某一角色登錄系統。
	 * 
	 * @param userid 用戶標識。
	 * @return
	 */
	@At("/as/?")
	@Ok("re")
	public Object as(String userid) {
		String ticket = new StringGenerator(19, 19).next();
		Subject subject = SecurityUtils.getSubject();
		log.infof("userid = %s", userid);
		UsernameTicketToken token = new UsernameTicketToken(userid, ticket);
	    token.setRememberMe(true);
        // 更新票根。
	    Result result = userService.updateTicket(userid, ticket);
	    if(result != null && result.isOK()) {
	    	subject.login(token);
	    	subject.getSession().setAttribute("ticket", ticket);
	    }
        return ">>:/home";
	}
	
	@At("/noauth")
	public Object noauth() {
		return "未授權";
	}
}