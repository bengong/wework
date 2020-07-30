package wework;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;

public interface Wework extends java.io.Serializable {
	
	/**
	 * GET
	 * 
	 * @param url
	 * @return
	 */
	public Object get(String url);
	
	/**
	 * GET
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public Object get(String url, Map<String, Object> params);
	
	/**
	 * POST。
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public Object post(String url, Object data);
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * 
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public Object post(String url, Object data, int timeout);
    
    /**
     * 上传文件。
     * 
     * @param url
     * @param params
     * @param header
     * @return
     */
    public Object upload(String url, Map<String, Object> params, Header header);
    
    /**
     * 下载。
     * 
     * @param url
     * @return
     */
    public InputStream download(String url);
    
    /**
     * 获取公司主键。
     * 
     * @return corpid
     */
    public String corpid();
    
    /**
     * 获取应用。
     * 
     * @param agentid
     * @return agent
     */
    public Object agent(String agentid);
}
