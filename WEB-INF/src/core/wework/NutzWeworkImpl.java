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

		
	public String server_url = "https://qyapi.weixin.qq.com/cgi-bin";
	
	protected int Default_timeout = 60*1000;
	
	protected Log log = Logs.get();
	
	public final Object get(String url) {
		log.info(url);		
		return result(Http.get(server_url+url, Default_timeout));
    }
	
	public final Object get(String url, Map<String, Object> params) {
		return result(Http.get(server_url+url, params, Default_timeout));
    }
	
	public final Object postJson(String url, Object data) {		
        return postJson(url, data, Default_timeout);
    }
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * 
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public final Object postJson(String url, Object data, int timeout) {
        Request req = Request.create(server_url+url, METHOD.POST);
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
    public final Object upload(String url, Map<String, Object> params, Header header) {
    	return result(Http.upload(server_url+url, params, header, Default_timeout));
    }
    
    public final InputStream download(String url) {
    	return Http.get(server_url+url, Default_timeout).getStream();
    }
    
    /**
     * 获取结果对象。
     *  
     * @param response
     * @return
     */
    private final Object result(Response response) {
    	
    	if(response.isServerError()) {
    		throw new WeException("服务端出错 "+response.getStatus() + response.getDetail());
    	}
    	if(response.isClientError()) {
    		throw new WeException("客户端出错 "+response.getStatus() + response.getDetail());
    	}
    	
    	//  不正常返回。
    	if(!response.isOK()) {
    		throw new WeException(response.getDetail());
    	}
    	    	
    	String content = response.getContent();
    	
    	log.info(Json.toJson(response));
    	
    	Object result = Json.fromJson(content);
    	if(result != null) {
    		Integer errcode =  (Integer)Mapl.cell(result, "errcode");
    		String errmsg =  (String)Mapl.cell(result, "errmsg");
    		if(errcode != 0) {
    			throw new WeException(errmsg);
    		}
    	}
    	
    	return result;
    }

}