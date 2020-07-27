package wework.domain;

/**
 * 应用。
 */
public class Application {
	
	public String agentId;
	public String secret;
	
	public String corpid;
	
	public String access_token;
	public long expires_in;
	public long access_time;
	
	public Application() {
	}
	
	public Application(String agentId, String secret) {
		this.agentId = agentId;
		this.secret = secret;
	}
}
