package wework.util;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.http.Response;
import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

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
    
    /**
     * 获取结果对象。
     *  
     * @param response
     * @return
     */
    private Object result(Response response) {
    	
    	if(response.isServerError()) {
    		throw new BusinessException("服务端出错 "+response.getStatus() + response.getDetail());
    	}
    	if(response.isClientError()) {
    		throw new BusinessException("客户端出错 "+response.getStatus() + response.getDetail());
    	}
    	
    	//  不正常返回。
    	if(!response.isOK()) {
    		throw new BusinessException(response.getDetail());
    	}
    	    	
    	String content = response.getContent();
    	return result(content);
    }
    
    private Object result(String content) {    	
    	log.info(Json.toJson(content));
    	
    	Object result = Json.fromJson(content);
    	if(result != null) {
    		Integer errcode =  (Integer)Mapl.cell(result, "errcode");
    		String errmsg =  (String)Mapl.cell(result, "errmsg");
    		if(errcode != 0) {
    			throw new BusinessException(errmsg);
    		}
    	}
    	
    	return result;
    }

	@Override
	public void setPath(String path) {
		this.path = path;
	}
}
