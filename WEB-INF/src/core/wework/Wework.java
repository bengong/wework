package wework;

import java.util.Map;

import org.nutz.http.Http;
import org.nutz.http.Request;
import org.nutz.http.Request.METHOD;
import org.nutz.http.Response;
import org.nutz.http.Sender;
import org.nutz.json.Json;
import org.nutz.mapl.Mapl;

import wework.domain.Corp;

/**
 * 缺省企业微信对象。
 */
public class Wework {
	public static String server_url = "https://qyapi.weixin.qq.com/cgi-bin";
	
	public Corp corp;
	
	public static int Default_timeout = 30*1000;
	
	public static Response get(String url) {
        return Http.get(url, Default_timeout);
    }
	
	public static Response get(String url, Map<String, Object> params) {
        return Http.get(url, params, Default_timeout);
    }
	
	public static Response postJson(String url, Mapl data) {
        return postJson(url, data, Default_timeout);
    }
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public static Response postJson(String url, Mapl data, int timeout) {
        Request req = Request.create(url, METHOD.POST);
        req.setData(Json.toJson(data));
        req.getHeader().set("Content-Type", "application/json");
        return Sender.create(req).setTimeout(timeout).send();
    }
    
    public static <T> T as(Class<T> type, Response response) {
    	Mapl data = as(response);
    	
    	return (T)Mapl.maplistToObj(data, type);
    }
    
    public static Mapl as(Response response) {
    	String content = response.getContent();
    	Mapl data = (Mapl)Mapl.toMaplist(content);
    	if(data != null) {
    		Integer errcode =  (Integer)Mapl.cell(data, "errcode");
    		String errmsg =  (String)Mapl.cell(data, "errmsg");
    		if(errcode != 0) {
    			throw new WeException(errmsg);
    		}
    	}
    	
    	return data;
    }
}
