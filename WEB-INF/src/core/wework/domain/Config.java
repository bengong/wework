package wework.domain;

import java.util.HashMap;
import java.util.Map;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;

@IocBean
public class Config {
	/**
	 * 公司标识。
	 */
	public String corpid;	
	/**
	 * 其他应用。
	 */
	public Map<String, Object> agents = new HashMap<String, Object>();
	
	public String toString() {
		return Json.toJson(this);
	}
}
