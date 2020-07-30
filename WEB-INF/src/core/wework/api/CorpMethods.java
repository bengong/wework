package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * 公司。
 */
@IocBean
public class CorpMethods  extends AbstractMethods {
		
	Log log = Logs.get();

	public CorpMethods() {
		super();
	}
}
