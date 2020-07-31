package wework.util;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.http.Http;
import org.nutz.http.Request;
import org.nutz.http.Request.METHOD;
import org.nutz.http.Response;
import org.nutz.http.Sender;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

@IocBean(name="postman")
public class NutPostman implements Postman {
	
	protected Log log = Logs.get();
	
	public Object get(String url) {
		log.info(url);		
		return result(Http.get(url, Default_timeout));
    }
	
	public Object get(String url, Map<String, Object> params) {
		return result(Http.get(url, params, Default_timeout));
    }
	
	public Object post(String url, Object data) {		
        return post(url, data, Default_timeout);
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
        Request req = Request.create(url, METHOD.POST);
        req.getHeader().set("Content-Type", "application/json");
        req.setData(Json.toJson(data));       
        return result(Sender.create(req).setTimeout(timeout).send());
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
    	return result(Http.upload(url, params, header, Default_timeout));
    }
    
    public InputStream download(String url) {
    	return Http.get(url, Default_timeout).getStream();
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
    	
    	log.info(Json.toJson(response.getHeader()));    	
    	
    	Object result = Json.fromJson(content);
    	
    	
    	if(result != null) {
    		Integer errcode =  (Integer)Mapl.cell(result, "errcode");
    		String errmsg =  (String)Mapl.cell(result, "errmsg");
    		if(errcode != 0) {
    			throw new BusinessException(errmsg);
    		}
    	}
    	
    	log.info(Json.toJson(result));
    	return result;
    }

	@Override
	public void setPath(String path) {
	}
}
