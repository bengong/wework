package wework;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
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

	Log log = Logs.get();
	
	@At("/")
	public String home() {
		return "Wework Open API";
	}
}