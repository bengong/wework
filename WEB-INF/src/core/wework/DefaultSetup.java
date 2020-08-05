package wework;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
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
		
		Ioc ioc = config.getIoc();
		Dao dao = ioc.get(Dao.class);
		String debug = System.getProperty("debug", "true");
		if(debug.equalsIgnoreCase("true")) {
			// 新建表表结构
			Daos.createTablesInPackage(dao, "wework.domain", false);
			// 更新表结构
			 Daos.migration(dao, "wework.domain", true, true);
		}
	}

	@Override
	public void destroy(NutConfig config) {	
	}
}