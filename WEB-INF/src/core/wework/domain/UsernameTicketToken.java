package wework.domain;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;
import org.nutz.json.Json;

public class UsernameTicketToken  implements HostAuthenticationToken, RememberMeAuthenticationToken {
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6915467548034290598L;

	/**
     * The username
     */
    private String username;

    /**
     * code 企業微信返回的code編碼。
     */
    private String ticket;

    /**
     * Whether or not 'rememberMe' should be enabled for the corresponding login attempt;
     * default is <code>false</code>
     */
    private boolean rememberMe = false;

    /**
     * The location from where the login attempt occurs, or <code>null</code> if not known or explicitly
     * omitted.
     */
    private String host;
    
    private User user;

    public UsernameTicketToken() {
    }

    public UsernameTicketToken(final String username, final String ticket) {
        this(username, ticket, false, null);
    }

    public UsernameTicketToken(final String username, final String ticket, final boolean rememberMe, final String host) {

        this.username = username;
        this.ticket = ticket;
        this.rememberMe = rememberMe;
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Object getPrincipal() {
        return getUsername();
    }

    public Object getCredentials() {
        return getTicket();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void clear() {
        this.username = null;
        this.host = null;
        this.rememberMe = false;

        if (this.ticket != null) {
            this.ticket = null;
        }
    }

    public String toString() {
        return Json.toJson(this);
    }
}
