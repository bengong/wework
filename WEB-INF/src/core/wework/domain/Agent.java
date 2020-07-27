package wework.domain;

/**
 * 应用。
 */
public class Agent {
	
	public String agentId;
	public String secret;
	
	public String corpid;
	
	public String access_token;
	public Integer expires_in;
	public Long access_time;
	
	public Agent() {
	}
	
	public Agent(String agentId, String secret) {
		this.agentId = agentId;
		this.secret = secret;
	}
}
