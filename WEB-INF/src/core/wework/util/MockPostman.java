package wework.util;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * 
 */
public class MockPostman implements Postman {
	
	public String path;
	
	protected Log log = Logs.get();
	
	public Object get(String url) {		
		return Json.fromJson(Files.read(path));
    }
	
	public Object get(String url, Map<String, Object> params) {
		return Json.fromJson(Files.read(path));
    }
	
	public Object post(String url, Object data) {		
		return Json.fromJson(Files.read(path));
    }
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * 
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public Object post(String url, Object data, int timeout) {
    	return Json.fromJson(Files.read(path));
    }    
    
    /**
     * 上传文件。
     * 
     * @param url
     * @param params
     * @param header
     * @return
     */
    public Object upload(String url, Map<String, Object> params, Header header) {
    	return Json.fromJson(Files.read(path));
    }
    
    public InputStream download(String url) {
    	return Files.findFileAsStream(path);
    }
    
	@Override
	public void setPath(String path) {
		this.path = path;
	}
}
