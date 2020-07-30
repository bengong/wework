package wework;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.nutz.lang.Files;

public abstract class WeworkTestBase {
	    protected Properties p;

	    @Before
	    public void setUp() throws Exception {
	        InputStream is = Files.findFileAsStream("/test.properties");
	        p = new Properties();
	        if (is != null) {
	            p.load(is);
	            is.close();
	        }
	    }	    
}
