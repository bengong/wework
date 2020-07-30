package wework;

import java.util.HashMap;
import java.util.Map;

import org.nutz.ioc.loader.annotation.IocBean;

@IocBean
public class WeConfig {
	/**
	 * 公司标识。
	 */
	public String corpid;	
	/**
	 * 其他应用。
	 */
	public Map<String, Object> agents = new HashMap<String, Object>();
}
