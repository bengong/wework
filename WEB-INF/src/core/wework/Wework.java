package wework;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;

public interface Wework extends java.io.Serializable {
	
	public static String server_url = "https://qyapi.weixin.qq.com/cgi-bin";
	
	public Object get(String url);
	
	public Object get(String url, Map<String, Object> params);
	
	public Object postJson(String url, Object data);
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public Object postJson(String url, Object data, int timeout);
    
    /**
     * 上传文件。
     * 
     * @param url
     * @param params
     * @param header
     * @return
     */
    public Object upload(String url, Map<String, Object> params, Header header);
    
    public InputStream download(String url);
}
