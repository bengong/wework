package wework;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.h2.tools.Server;
import org.nutz.lang.Files;

/**
 * H2数据库启动/关闭监听器。如何制定备份文件的路径？
 */
public class DatabaseListener implements ServletContextListener {
	protected Log log = LogFactory.getLog(DatabaseListener.class);
	private Server server = null;

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			
			Files.createDirIfNoExists("c:/runtime/h2/data");
			Files.createDirIfNoExists("c:/runtime/h2/backup");
			
			String[] args = new String[] { "-tcp", "-tcpAllowOthers", "-webAllowOthers", "-trace", "-tcpPort", "9092", "-baseDir", "c:/runtime/h2/data", "-web" };
			server = new Server();
			log.info("Starting H2 Database...");
			server.runTool(args);
			log.info("H2 Database started success.");
		} catch (SQLException e) {
			log.info("H2 Database Error " + "\n" + e.getMessage());
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		if (server != null) {
			log.info("Closing H2 Database...");
			server.stop();
			server.shutdown();
			log.info("H2 Database Closed.");
		}
	}
}
