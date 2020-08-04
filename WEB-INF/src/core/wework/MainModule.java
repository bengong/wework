package wework;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
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

import wework.util.BusinessException;

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
	
	Log log = Logs.get();
	
	@At("/")
	@Ok("re")
	public Object home(String code, String state, ViewModel model) {
		String agentid = "1000002";
		Object userinfo = null;
		
		model.setv("basic", "./");
		model.setv("code", code);
		model.setv("state", state);
		try {
			userinfo = wework.user.getuserinfo(agentid, code);
			if(!Lang.isEmpty(userinfo)) {
				model.setv("userid", Mapl.cell(userinfo, "UserId"));
				model.setv("deviceid", Mapl.cell(userinfo, "DeviceId"));
			}
			return "->:/home"; // 返回null, 则代表走默认视图
		} catch (BusinessException e) {
			log.error(e);			
			return "->:/home/login";
		}
	}	
}