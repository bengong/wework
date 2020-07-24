package wework;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class DefaultSetup implements Setup {
	Log log = Logs.get();
	
	@Override
	public void init(final NutConfig config) {		
		// 设置默认文档编码方式 UTF-8
		System.setProperty("file.encoding", "UTF-8");
		// 设置默认文档分割格式 /
		System.setProperty("file.separator", "/");
	}

	@Override
	public void destroy(NutConfig config) {	
	}
}