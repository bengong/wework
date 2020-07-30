package wework;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.http.Http;
import org.nutz.http.Request;
import org.nutz.http.Request.METHOD;
import org.nutz.http.Response;
import org.nutz.http.Sender;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

/**
 * 缺省企业微信对象。
 */
public class NutzWeworkImpl implements Wework {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9220340149800920348L;

	protected Log log = Logs.get();
	
	protected int Default_timeout = 60*1000;
	
	public Object get(String url) {
		log.info(url);		
		return as(Http.get(url, Default_timeout));
    }
	
	public Object get(String url, Map<String, Object> params) {
		return as(Http.get(url, params, Default_timeout));
    }
	
	public Object postJson(String url, Object data) {		
        return postJson(url, data, Default_timeout);
    }
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public Object postJson(String url, Object data, int timeout) {
        Request req = Request.create(url, METHOD.POST);
        req.getHeader().set("Content-Type", "application/json");
        req.setData(Json.toJson(data));        
        Response response = Sender.create(req).setTimeout(timeout).send();
        
        return as(response);
    }

    public <T> T as(Class<T> type, Response response) {
    	Object data = as(response);    	
    	return (T)Mapl.maplistToObj(data, type);
    }
    
    public Object as(Response response) {
    	String content = response.getContent();
    	
    	log.info(Json.toJson(response));
    	log.info(Json.toJson(content));
    	
    	Object data = Json.fromJson(content);
    	if(data != null) {
    		Integer errcode =  (Integer)Mapl.cell(data, "errcode");
    		String errmsg =  (String)Mapl.cell(data, "errmsg");
    		if(errcode != 0) {
    			throw new WeException(errmsg);
    		}
    	}
    	
    	return data;
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
    	return as(Http.upload(url, params, header, Default_timeout));
    }
    
    public InputStream download(String url) {
    	return Http.get(url, Default_timeout).getStream();
    }
}