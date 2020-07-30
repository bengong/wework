package wework;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.log.Log;
import org.nutz.log.Logs;

public abstract class AbstractMethods {
	@Inject
	private Wework wework;
	
	protected Log log = Logs.get();
	
	protected Object get(String url) {
		return wework.get(url);
	}
	
	protected Object get(String url, Map<String, Object> params) {
		return wework.get(url, params);
	}
	
	protected Object postJson(String url, Object data) {
		return wework.postJson(url, data);
	}
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
	protected Object postJson(String url, Object data, int timeout) {
    	return wework.postJson(url, data, timeout);
    }

	protected Object upload(String url, Map<String, Object> params, Header header) {
    	return wework.upload(url, params, header);
    }
    
	protected InputStream download(String url) {
    	return wework.download(url);
    }
}
