package wework.util;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;

public interface Postman {
	
	public int Default_timeout = 60*1000;

	/**
	 * GET
	 * 
	 * @param url
	 * @return
	 */
	public abstract Object get(String url);
	
	/**
	 * GET
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public abstract Object get(String url, Map<String, Object> params);
	
	/**
	 * POST。
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public abstract Object post(String url, Object data);
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * 
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public abstract Object post(String url, Object data, int timeout);
    
    /**
     * 上传文件。
     * 
     * @param url
     * @param params
     * @param header
     * @return
     */
    public abstract Object upload(String url, Map<String, Object> params, Header header);
    
    /**
     * 下载。
     * 
     * @param url
     * @return
     */
    public abstract InputStream download(String url);
    
    /**
     * 设置mock数据。
     * 
     * @param path
     */
    public void setPath(String path);
}
