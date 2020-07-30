package wework;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.log.Log;
import org.nutz.log.Logs;

public class MockWeworkImpl implements MockWework {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6716279383055812605L;

	String mock_file;	
	Log log = Logs.get();
	
	public Object get(String url) {
		log.info(url);
		return Json.fromJson(Files.read(mock_file));
    }
	
	public Object get(String url, Map<String, Object> params) {
		return Json.fromJson(Files.read(mock_file));
    }
	
	public Object postJson(String url, Object data) {
		return Json.fromJson(Files.read(mock_file));
    }
	
	/**
	 * 将数据对象转换成json后，post出去。
	 * @param url
	 * @param data
	 * @param timeout
	 * @return
	 */
    public Object postJson(String url, Object data, int timeout) {
    	return Json.fromJson(Files.read(mock_file));
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
    	return Json.fromJson(Files.read(mock_file));
    }
    
    public InputStream download(String url) {
    	return Files.findFileAsStream(mock_file);
    }

	@Override
	public void setMock_file(String mock_file) {
		this.mock_file = mock_file;
	}
}