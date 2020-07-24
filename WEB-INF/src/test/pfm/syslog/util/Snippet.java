package pfm.syslog.util;

import javax.net.ssl.SSLSession;

import com.sun.net.ssl.HostnameVerifier;

public class Snippet {
	final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
		
		@Override
		public boolean verify(String arg0, String arg1) {
			return true;
		}
	};
}

